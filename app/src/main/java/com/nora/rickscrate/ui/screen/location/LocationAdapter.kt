package com.nora.rickscrate.ui.screen.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.nora.rickscrate.databinding.ItemLocationBinding
import com.nora.rickscrate.domain.model.Location

class LocationAdapter :
    PagingDataAdapter<Location, LocationAdapter.LocationViewHolder>(LocationComparator) {

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLocationBinding.inflate(inflater, parent, false)
        return LocationViewHolder(binding)
    }

    inner class LocationViewHolder(private val itemBinding: ItemLocationBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Location) {
            itemBinding.location = item
            itemBinding.executePendingBindings()
        }
    }

    object LocationComparator : DiffUtil.ItemCallback<Location>() {
        override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem.id == newItem.id
        }
    }
}