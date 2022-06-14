package com.example.catsbrowser.tools.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catsbrowser.domain.model.Breed
import com.example.catsbrowser.ui.breeds.adapter.BreedsRecyclerViewAdapter

@BindingAdapter(value = ["setBreeds"])

fun setRecyclerViewBreedsList(
    nRecyclerView: RecyclerView,
    nBreedsList: List<Breed>?
) {
    if (nBreedsList != null) {
        val mUiBreedsListAdapter = BreedsRecyclerViewAdapter(nRecyclerView.context)
        nRecyclerView.apply {
            this.layoutManager = LinearLayoutManager(this.context)
            this.adapter = mUiBreedsListAdapter
        }
        mUiBreedsListAdapter.submitBreedsList(nBreedsList)
    }
}