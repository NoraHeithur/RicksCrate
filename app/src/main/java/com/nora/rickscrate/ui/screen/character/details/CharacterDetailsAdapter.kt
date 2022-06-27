package com.nora.rickscrate.ui.screen.character.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nora.rickscrate.databinding.ItemEpisodeBoundBinding
import com.nora.rickscrate.domain.model.EpisodeBound

class CharacterDetailsAdapter :
    ListAdapter<EpisodeBound, CharacterDetailsAdapter.CharacterDetailViewHolder>(
        CharacterDetailsComparator
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterDetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemEpisodeBoundBinding.inflate(inflater, parent, false)
        return CharacterDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterDetailViewHolder, position: Int) {
        getItem(position)?.let { holder.bindView(it) }
    }

    inner class CharacterDetailViewHolder(private val itemBinding: ItemEpisodeBoundBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindView(item: EpisodeBound) {
            itemBinding.episode = item
            itemBinding.executePendingBindings()
        }
    }

    object CharacterDetailsComparator : DiffUtil.ItemCallback<EpisodeBound>() {
        override fun areItemsTheSame(oldItem: EpisodeBound, newItem: EpisodeBound): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: EpisodeBound, newItem: EpisodeBound): Boolean {
            return oldItem.id == newItem.id
        }
    }


}