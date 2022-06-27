package com.nora.rickscrate.ui.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nora.rickscrate.R
import com.nora.rickscrate.databinding.ItemNetworkStateBinding

class PagingLoadStateAdapter(private val retry: () -> Unit) :
    LoadStateAdapter<PagingLoadStateAdapter.PagingLoadStateViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): PagingLoadStateViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_network_state, parent, false)
        val binding = ItemNetworkStateBinding.bind(inflater)
        return PagingLoadStateViewHolder(binding, retry)
    }

    override fun onBindViewHolder(holder: PagingLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    class PagingLoadStateViewHolder(
        private val binding: ItemNetworkStateBinding,
        private val retry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.networkRetryBtn.setOnClickListener { retry.invoke() }
        }

        fun bind(loadState: LoadState) {
            binding.networkRetryBtn.isVisible = loadState is LoadState.Error
            binding.networkStateAnimation.isVisible = loadState is LoadState.Loading
            binding.networkStateTv.isVisible = loadState is LoadState.Error
            binding.networkStateTv.text = (loadState as? LoadState.Error)?.error?.message
        }
    }
}