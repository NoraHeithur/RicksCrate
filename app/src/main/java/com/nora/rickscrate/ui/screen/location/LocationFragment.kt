package com.nora.rickscrate.ui.screen.location

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.nora.rickscrate.R
import com.nora.rickscrate.databinding.FragmentCharacterBinding
import com.nora.rickscrate.databinding.FragmentLocationBinding
import com.nora.rickscrate.ui.base.BaseFragment
import com.nora.rickscrate.ui.utils.PagingLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class LocationFragment : BaseFragment<FragmentLocationBinding, LocationViewModel>() {

    private val viewModel: LocationViewModel by viewModels()

    private val locationAdapter = LocationAdapter()

    override val layout: Int
        get() = R.layout.fragment_location

    private fun collectData() {
        launchWithLifecycleScope {
            viewModel.locationFlow.collectLatest {
                locationAdapter.submitData(it)
            }
        }
    }

    private fun collectLoadState(
        loadState: Flow<CombinedLoadStates>,
        binding: FragmentLocationBinding,
        adapter: LocationAdapter
    ) {
        launchWithLifecycleScope {
            loadState.collectLatest { state ->
                val isEmptyList = state.refresh is LoadState.NotLoading && adapter.itemCount == 0

                val errorState = state.source.append as? LoadState.Error
                    ?: state.source.prepend as? LoadState.Error
                    ?: state.append as? LoadState.Error
                    ?: state.prepend as? LoadState.Error

                binding.swipeLocation.isRefreshing = if (!isEmptyList) {
                    false
                } else {
                    state.refresh is LoadState.Loading
                }

                binding.allLocationRv.apply {
                    isVisible =
                        state.refresh is LoadState.NotLoading || state.source.refresh is LoadState.NotLoading
                }

                binding.locationNetworkState.networkStateAnimation.apply {
                    isVisible = state.refresh is LoadState.Loading
                }

                binding.locationNetworkState.networkRetryBtn.apply {
                    isVisible = state.refresh is LoadState.Error
                    setOnClickListener {
                        adapter.retry()
                    }
                }

                binding.locationNetworkState.networkStateTv.apply {
                    isVisible = state.refresh is LoadState.Error
                }

                errorState?.let { stateMgs ->
                    var errorMgs = ""
                    stateMgs.error.message?.let { message ->
                        errorMgs = message
                        displayRefreshToast(message)
                    }
                    binding.locationNetworkState.networkStateTv.text = errorMgs
                }
            }
        }
    }

    override fun provideViewModel(): LocationViewModel = viewModel

    override fun initialize(binding: FragmentLocationBinding, viewModel: LocationViewModel) {
        binding.allLocationRv.apply {
            adapter = locationAdapter
        }

        binding.allLocationRv.adapter = locationAdapter.withLoadStateHeaderAndFooter(
            header = PagingLoadStateAdapter { locationAdapter.retry() },
            footer = PagingLoadStateAdapter { locationAdapter.retry() }
        )

        locationAdapter.apply {
            collectData()
            val swipe = binding.swipeLocation
            swipe.setOnRefreshListener {
                refresh()
            }
            collectLoadState(loadStateFlow, binding, this)
        }
    }

    override fun additionalInit() {}
}