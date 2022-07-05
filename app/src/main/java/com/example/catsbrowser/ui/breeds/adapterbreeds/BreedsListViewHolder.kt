package com.example.catsbrowser.ui.breeds.adapterbreeds

import android.view.View
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.catsbrowser.R
import com.example.catsbrowser.databinding.BreedItemBinding
import com.example.catsbrowser.domain.database.BreedsDao
import com.example.catsbrowser.domain.database.BreedsDatabase
import com.example.catsbrowser.domain.model.Breed

class BreedsListViewHolder(val view: View, listener: BreedsRecyclerViewAdapter.OnButtonClickListener) : RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener {
            listener.onDataClick(adapterPosition)
        }
    }

    fun bind(breed: Breed) {
        val binding: BreedItemBinding? = DataBindingUtil.getBinding(view)

        if (binding != null) {
            binding.breed = breed
            binding.executePendingBindings()

        }
    }
}