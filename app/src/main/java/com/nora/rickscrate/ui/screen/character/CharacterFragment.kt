package com.nora.rickscrate.ui.screen.character

import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.google.android.material.transition.MaterialElevationScale
import com.nora.rickscrate.R
import com.nora.rickscrate.databinding.FragmentCharacterBinding
import com.nora.rickscrate.domain.model.Character
import com.nora.rickscrate.ui.base.BaseFragment
import com.nora.rickscrate.ui.utils.PagingLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharacterViewModel>(),
    CharacterListener {

    private val viewModel: CharacterViewModel by viewModels()

    private val characterAdapter = CharacterAdapter(this)

    private var errorStateMessage = ""

    override val layout: Int
        get() = R.layout.fragment_character

    private fun bindingTransition() {
        exitTransition = MaterialElevationScale(false).apply {
            duration = resources.getInteger(R.integer.motion_duration_normal).toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = resources.getInteger(R.integer.motion_duration_normal).toLong()
        }
    }

    private fun collectData() {
        launchWithLifecycleScope {
            viewModel.characterFlow.collectLatest {
                characterAdapter.submitData(it)
            }
        }
    }

    private fun collectLoadState(
        loadState: Flow<CombinedLoadStates>,
        binding: FragmentCharacterBinding,
        adapter: CharacterAdapter
    ) {
        launchWithLifecycleScope {
            loadState.collectLatest { state ->
                val isEmptyList = state.refresh is LoadState.NotLoading && adapter.itemCount == 0

                val errorState = state.source.append as? LoadState.Error
                    ?: state.source.prepend as? LoadState.Error
                    ?: state.append as? LoadState.Error
                    ?: state.prepend as? LoadState.Error

                binding.swipeCharacter.isRefreshing = if (!isEmptyList) {
                    false
                } else {
                    state.refresh is LoadState.Loading
                }

                binding.characterNetworkState.root.isVisible = if (isEmptyList) {
                    state.refresh is LoadState.Error
                } else {
                    state.refresh is LoadState.Loading
                }

                binding.characterRv.apply {
                    isVisible =
                        state.refresh is LoadState.NotLoading || state.source.refresh is LoadState.NotLoading
                }

                binding.characterNetworkState.networkStateAnimation.apply {
                    isVisible = state.refresh is LoadState.Loading
                }

                binding.characterNetworkState.networkRetryBtn.apply {
                    isVisible = state.refresh is LoadState.Error
                    setOnClickListener {
                        adapter.retry()
                    }
                }

                binding.characterNetworkState.networkStateTv.apply {
                    isVisible = state.refresh is LoadState.Error
                }

                errorState?.let { stateMgs ->
                    var errorMgs = ""
                    stateMgs.error.message?.let { message ->
                        errorMgs = message
                        displayRefreshToast(message)
                    }
                    binding.characterNetworkState.networkStateTv.text = errorMgs
                    errorStateMessage = errorMgs
                }
            }
        }
    }

    override fun provideViewModel(): CharacterViewModel = viewModel

    override fun initialize(binding: FragmentCharacterBinding, viewModel: CharacterViewModel) {
        binding.characterRv.apply {
            adapter = characterAdapter
            postponeEnterTransition()
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }

        binding.characterRv.adapter = characterAdapter.withLoadStateHeaderAndFooter(
            header = PagingLoadStateAdapter { characterAdapter.retry() },
            footer = PagingLoadStateAdapter { characterAdapter.retry() }
        )

        characterAdapter.apply {
            collectData()
            binding.swipeCharacter.setOnRefreshListener {
                refresh()
            }
            collectLoadState(loadStateFlow, binding, this)
        }
    }

    override fun onItemClicked(view: View, item: Character) {
        bindingTransition()
        val itemTransition = getString(R.string.character_details_transition_name)
        val extras = FragmentNavigatorExtras(view to itemTransition)
        val directions =
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailsFragment(item, errorStateMessage)

        findNavController().navigate(directions, extras)
    }

    override fun additionalInit() {}
}