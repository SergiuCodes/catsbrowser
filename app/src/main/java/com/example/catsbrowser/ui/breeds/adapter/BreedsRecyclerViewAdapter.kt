package com.example.catsbrowser.ui.breeds.adapter

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.catsbrowser.domain.model.Breed

class BreedsRecyclerViewAdapter(private val nContext: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mBreedsList: List<Breed> = ArrayList()
    private lateinit var mRowBinding: ViewDataBinding

    fun submitBreedsList(nList: List<Breed>) {
        mBreedsList = nList
        notifyDataSetChanged()
        Log.d("testadapter", "submitted breed list adapter size: ${mBreedsList.size}")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}