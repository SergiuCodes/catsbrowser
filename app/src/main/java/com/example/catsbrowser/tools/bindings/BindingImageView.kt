package com.example.catsbrowser.tools.bindings

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value =["setBreedImageFromUrl"])
fun Context.loadImage (imageView: ImageView, url: String) {
    Glide
        .with(this)
        .load(url)
        .centerCrop()
        .into(imageView)
}
