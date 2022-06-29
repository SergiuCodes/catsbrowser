package com.example.catsbrowser.ui.breeds.adapterbreeds

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.catsbrowser.R
import com.example.catsbrowser.domain.model.Breed
import timber.log.Timber

class BreedsRecyclerViewAdapter(private val nContext: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mBreedsList: List<Breed> = ArrayList()
    private lateinit var mRowBinding: ViewDataBinding
    private lateinit var mOnDataClickListener: OnButtonClickListener
    private lateinit var mDialog: Dialog

    fun setOnButtonClickListener(listener: OnButtonClickListener) {
        mOnDataClickListener = listener
    }

    fun submitBreedsList(nList: List<Breed>) {
        mBreedsList = nList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        mRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(nContext),
            R.layout.breed_item,
            parent,
            false)

        return BreedsListViewHolder(mRowBinding.root, mOnDataClickListener)


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Timber.tag("testadapter").d("onBindViewHolder called")

        val breedsList = mBreedsList[position]
        (holder as BreedsListViewHolder).bind(breedsList)

    }

    override fun getItemCount(): Int {
        Timber.tag("testadapter").d("getItemCount called%s", mBreedsList.size)
        return mBreedsList.size
    }

    interface OnButtonClickListener {
        fun onDataClick(position: Int)
    }
}