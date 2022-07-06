package com.example.catsbrowser.ui.breeds.adapterbreeds

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.catsbrowser.R
import com.example.catsbrowser.domain.database.BreedsDao
import com.example.catsbrowser.domain.database.BreedsDatabase
import com.example.catsbrowser.domain.model.Breed

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
        val dbBreeds = breedsDao.selectAllBreeds()

        (holder as BreedsListViewHolder).bind(breedsItem)

        dbBreeds.forEachIndexed { index, breed ->
            if (breed.isFavorite) {
                starCheckBoxButton.isChecked
            } else{
                starCheckBoxButton.isChecked = false
            }
        }

        starCheckBoxButton.setOnCheckedChangeListener { checkBox, isChecked ->

            if (isChecked) {
                dbBreeds[position].isFavorite = true
                breedsItem.isFavorite = true
                breedsDao.insert(breedsItem)
//                favoriteBreedsList.add(breedsList)
            } else {
                dbBreeds[position].isFavorite = false
                breedsItem.isFavorite = false
                breedsDao.insert(breedsItem)
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
