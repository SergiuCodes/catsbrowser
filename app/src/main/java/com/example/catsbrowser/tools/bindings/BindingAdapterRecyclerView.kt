package com.example.catsbrowser.tools.bindings

import android.app.Dialog
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catsbrowser.R
import com.example.catsbrowser.domain.model.Breed
import com.example.catsbrowser.ui.breeds.adapterbreeds.BreedsRecyclerViewAdapter

@BindingAdapter(value = ["setBreeds"])

fun setRecyclerViewBreedsList(
    nRecyclerView: RecyclerView,
    nBreedsList: List<Breed>?
) {
    if (nBreedsList != null) {
        val mUiBreedsListAdapter = BreedsRecyclerViewAdapter(nRecyclerView.context)
        nRecyclerView.apply {
            this.layoutManager = GridLayoutManager(this.context, 2)
            this.adapter = mUiBreedsListAdapter
        }
        mUiBreedsListAdapter.setOnButtonClickListener(object : BreedsRecyclerViewAdapter.OnButtonClickListener {
            override fun onDataClick(position: Int) {

                Toast.makeText(nRecyclerView.context, "Clicked on item no + $position", Toast.LENGTH_SHORT).show()

                var mDialog = Dialog(nRecyclerView.context)
                mDialog.setContentView(R.layout.details_fragment_dialog)
                mDialog = Dialog(nRecyclerView.context)
                mDialog.setContentView(R.layout.details_fragment_dialog)
                var details_cat_title = mDialog.findViewById<TextView>(R.id.details_cat_title)
                var details_cat_text = mDialog.findViewById<TextView>(R.id.details_cat_text)
                details_cat_text.text = nBreedsList[position].description
                details_cat_title.text = nBreedsList[position].name

                details_cat_text.movementMethod = ScrollingMovementMethod()
                mDialog.show()
            }


        })
        mUiBreedsListAdapter.submitBreedsList(nBreedsList)
    }
}