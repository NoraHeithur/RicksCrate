package com.nora.rickscrate.ui.screen.episode

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.nora.rickscrate.R
import com.nora.rickscrate.databinding.FragmentEpisodeBinding
import com.nora.rickscrate.ui.base.BaseFragment
import com.nora.rickscrate.ui.utils.PagingLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class EpisodeFragment : BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>() {

    private val viewModel: EpisodeViewModel by viewModels()

    private val episodeAdapter = EpisodeAdapter()

    override val layout: Int
        get() = R.layout.fragment_episode

    private fun collectData() {
        launchWithLifecycleScope {
            viewModel.episodeFlow.collectLatest {
                episodeAdapter.submitData(it)
            }
        }
    }

    private fun collectLoadState(
        loadState: Flow<CombinedLoadStates>,
        binding: FragmentEpisodeBinding,
        adapter: EpisodeAdapter
    ) {
        launchWithLifecycleScope {
            loadState.collectLatest { state ->
                val isEmptyList = state.refresh is LoadState.NotLoading && adapter.itemCount == 0

                val errorState = state.source.append as? LoadState.Error
                    ?: state.source.prepend as? LoadState.Error
                    ?: state.append as? LoadState.Error
                    ?: state.prepend as? LoadState.Error

                binding.swipeEpisode.isRefreshing = if (!isEmptyList) {
                    false
                } else {
                    state.refresh is LoadState.Loading
                }

                binding.allEpisodeRv.apply {
                    isVisible =
                        state.refresh is LoadState.NotLoading || state.source.refresh is LoadState.NotLoading
                }

                binding.episodeNetworkState.networkStateAnimation.apply {
                    isVisible = state.refresh is LoadState.Loading
                }

                binding.episodeNetworkState.networkRetryBtn.apply {
                    isVisible = state.refresh is LoadState.Error
                    setOnClickListener {
                        adapter.retry()
                    }
                }

                binding.episodeNetworkState.networkStateTv.apply {
                    isVisible = state.refresh is LoadState.Error
                }

                errorState?.let { stateMgs ->
                    var errorMgs = ""
                    stateMgs.error.message?.let { message ->
                        errorMgs = message
                        displayRefreshToast(message)
                    }
                    binding.episodeNetworkState.networkStateTv.text = errorMgs
                }
            }
        }
    }

    override fun provideViewModel(): EpisodeViewModel = viewModel

    override fun initialize(binding: FragmentEpisodeBinding, viewModel: EpisodeViewModel) {
        binding.allEpisodeRv.apply {
            adapter = episodeAdapter
        }

        binding.allEpisodeRv.adapter = episodeAdapter.withLoadStateHeaderAndFooter(
            header = PagingLoadStateAdapter { episodeAdapter.retry() },
            footer = PagingLoadStateAdapter { episodeAdapter.retry() }
        )

        episodeAdapter.apply {
            collectData()
            val swipe = binding.swipeEpisode
            swipe.setOnRefreshListener {
                refresh()
            }
            collectLoadState(loadStateFlow, binding, this)
        }
    }

    override fun additionalInit() {}
}