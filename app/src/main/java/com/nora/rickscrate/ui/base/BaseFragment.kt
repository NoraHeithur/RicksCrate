package com.nora.rickscrate.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.nora.rickscrate.R
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseFragment<Binding: ViewDataBinding, ViewModel: BaseViewModel> : Fragment() {
    private lateinit var viewModel: ViewModel
    private lateinit var binding: Binding

    @get:LayoutRes
    abstract val layout: Int

    abstract fun provideViewModel(): ViewModel

    abstract fun initialize(binding: Binding, viewModel: ViewModel)

    abstract fun additionalInit()

    fun launchWithLifecycleScope(execute: suspend () -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            execute()
        }
    }

    fun displayRefreshToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = provideViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        additionalInit()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize(binding = binding, viewModel = viewModel)
    }
}