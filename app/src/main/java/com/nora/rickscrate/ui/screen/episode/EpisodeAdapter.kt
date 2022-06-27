package com.nora.rickscrate.ui.screen.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nora.rickscrate.databinding.ItemEpisodeBinding
import com.nora.rickscrate.domain.model.Episode

class EpisodeAdapter :
    PagingDataAdapter<Episode, EpisodeAdapter.EpisodeViewHolder>(EpisodeComparator) {

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodeBinding.inflate(inflater, parent, false)
        return EpisodeViewHolder(binding)
    }

    inner class EpisodeViewHolder(private val itemBinding: ItemEpisodeBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Episode) {
            itemBinding.episode = item
            itemBinding.executePendingBindings()
        }
    }

    object EpisodeComparator : DiffUtil.ItemCallback<Episode>() {
        override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem.id == newItem.id
        }
    }
}