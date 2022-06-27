package com.nora.rickscrate.ui.screen.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nora.rickscrate.domain.model.Character
import com.nora.rickscrate.databinding.ItemCharacterBinding

class CharacterAdapter(private val listener: CharacterListener) :
    PagingDataAdapter<Character, CharacterAdapter.CharacterViewHolder>(CharacterComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.bindView(it, listener) }
    }

    inner class CharacterViewHolder(private val itemBinding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bindView(item: Character, listener: CharacterListener) {
            itemBinding.character = item
            itemBinding.listener = listener
        }
    }

    object CharacterComparator : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }
    }
}