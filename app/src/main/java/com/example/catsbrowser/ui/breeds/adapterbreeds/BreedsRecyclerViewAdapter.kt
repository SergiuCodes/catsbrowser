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
    private var favoriteBreedsList: ArrayList<Breed> = ArrayList()

    fun setOnButtonClickListener(listener: OnButtonClickListener) {
        mOnDataClickListener = listener
    }

    fun submitBreedsList(nList: List<Breed>) {
        mBreedsList = nList
        notifyDataSetChanged()
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

        val starCheckBoxButton: CheckBox = mRowBinding.root.findViewById(R.id.favorites_checkbox)

        val breedsList = mBreedsList[position]
        (holder as BreedsListViewHolder).bind(breedsList)

        starCheckBoxButton.setOnCheckedChangeListener { checkBox, isChecked ->
            breedsDao = BreedsDatabase.getInstance(context).breedsDao()

            if (isChecked) {
                breedsDao.insert(mBreedsList[position])
                favoriteBreedsList.add(mBreedsList[position])
                Log.d("BreedsRecViewAdapter", "testing room insert first" + favoriteBreedsList.toString())

            } else {
                breedsDao.deleteBreed(mBreedsList[position])
                favoriteBreedsList.remove(mBreedsList[position])
                Log.d("BreedsRecViewAdapter", "testing room insert second" + favoriteBreedsList.toString())
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