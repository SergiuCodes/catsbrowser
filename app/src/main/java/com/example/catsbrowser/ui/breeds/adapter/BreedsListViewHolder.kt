package com.example.catsbrowser.ui.breeds.adapter

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.catsbrowser.databinding.BreedItemBinding
import com.example.catsbrowser.domain.model.Breed

class BreedsListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(breed: Breed) {
        val binding: BreedItemBinding? = DataBindingUtil.getBinding(view)

        if (binding != null) {
            binding.breed = breed
            binding.executePendingBindings()
        }
    }
}