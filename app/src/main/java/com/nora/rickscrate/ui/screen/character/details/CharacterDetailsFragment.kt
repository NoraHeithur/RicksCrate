package com.nora.rickscrate.ui.screen.character.details

import android.graphics.Color
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.nora.rickscrate.R
import com.nora.rickscrate.databinding.FragmentCharacterDetailsBinding
import com.nora.rickscrate.ui.base.BaseFragment
import com.nora.rickscrate.ui.utils.themeColor
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.count
import timber.log.Timber

@AndroidEntryPoint
class CharacterDetailsFragment : BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>() {

    private val viewModel: CharacterDetailsViewModel by viewModels()

    private val args: CharacterDetailsFragmentArgs by navArgs()

    private val detailAdapter = CharacterDetailsAdapter()

    override val layout: Int
        get() = R.layout.fragment_character_details

    private fun collectData() {
        launchWithLifecycleScope {
            viewModel.relatedEpisode.collectLatest {
                detailAdapter.submitList(it)
            }
        }
    }

    private fun setRelatedEpisodeData() {
        viewModel.setRelatedEpisode(args.character.episode)
    }

    override fun provideViewModel(): CharacterDetailsViewModel = viewModel

    override fun initialize(
        binding: FragmentCharacterDetailsBinding,
        viewModel: CharacterDetailsViewModel
    ) {
        binding.character = args.character

        setRelatedEpisodeData()

        binding.episodeBoundRv.apply {
            adapter = detailAdapter
        }
        collectData()
    }

    override fun additionalInit() {
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_fragment_main
            duration = resources.getInteger(R.integer.motion_duration_normal).toLong()
            scrimColor = Color.TRANSPARENT
            setAllContainerColors(requireContext().themeColor(com.google.android.material.R.attr.colorSurface))
        }
    }
}