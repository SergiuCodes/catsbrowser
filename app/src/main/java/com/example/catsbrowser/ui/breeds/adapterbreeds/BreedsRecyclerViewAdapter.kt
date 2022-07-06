package com.example.catsbrowser.ui.breeds.adapterbreeds

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.catsbrowser.R
import com.example.catsbrowser.domain.database.BreedsDao
import com.example.catsbrowser.domain.database.BreedsDatabase
import com.example.catsbrowser.domain.model.Breed
import timber.log.Timber

class BreedsRecyclerViewAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mBreedsList: List<Breed> = ArrayList()
    private lateinit var mRowBinding: ViewDataBinding
    private lateinit var mOnDataClickListener: OnButtonClickListener
    private lateinit var breedsDao: BreedsDao
//    private var favoriteBreedsList: ArrayList<Breed> = ArrayList()

    fun submitBreedsList(nList: List<Breed>) {
        mBreedsList = nList
        notifyDataSetChanged()
    }

    fun setOnButtonClickListener(listener: OnButtonClickListener) {
        mOnDataClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        mRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.breed_item,
            parent,
            false
        )
        return BreedsListViewHolder(mRowBinding.root, mOnDataClickListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        breedsDao = BreedsDatabase.getInstance(context).breedsDao()
        val starCheckBoxButton: CheckBox = mRowBinding.root.findViewById(R.id.favorites_checkbox)
        val breedsItem = mBreedsList[position]
        val dbBreed = breedsDao.selectAllBreeds()[position]

        (holder as BreedsListViewHolder).bind(breedsItem)

        if(dbBreed.isFavorite) {
            breedsItem.isFavorite
            starCheckBoxButton.isChecked
        } else {
            breedsItem.isFavorite = false
            starCheckBoxButton.isChecked = false
        }

        starCheckBoxButton.setOnCheckedChangeListener { checkBox, isChecked ->

            if (isChecked) {
                dbBreed.isFavorite = true
                breedsItem.isFavorite = true
                breedsDao.insert(dbBreed)
//                favoriteBreedsList.add(breedsList)
            } else {
                dbBreed.isFavorite = false
                breedsItem.isFavorite = false
                breedsDao.insert(dbBreed)
//                favoriteBreedsList.remove(mBreedsList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return mBreedsList.size
    }

    interface OnButtonClickListener {
        fun onDataClick(position: Int)
    }
}
