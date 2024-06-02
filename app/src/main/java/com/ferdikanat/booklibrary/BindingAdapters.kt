package com.ferdikanat.booklibrary

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ferdikanat.booklibrary.R

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view.context)
            .load(it)
            .apply(RequestOptions().placeholder(R.drawable.placeholder).error(R.drawable.error))
            .into(view)
    } ?: run {
        view.setImageResource(R.drawable.error) // Use a local error image
    }
}
