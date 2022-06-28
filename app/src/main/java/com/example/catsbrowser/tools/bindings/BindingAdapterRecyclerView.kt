package com.example.catsbrowser.tools.bindings

import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

                //TODO() SET THE CLICK LISTENER ONLY ON BUTTON NOT THE WHOLE CARD
                //TODO() SHOW DIALOG FRAGMENT ON CLICK
                //doesnt work
                //DialogFragment().show(DialogFragment().childFragmentManager, DetailsDialogFragment.TAG)
            }

        })
        mUiBreedsListAdapter.submitBreedsList(nBreedsList)
    }
}