package com.sergiorivera.demo02

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.imageFromUrl(imageURL: String, placeholderID: Int = R.drawable.water_bottle){
    Glide.with(this).load(imageURL).placeholder(placeholderID).into(this)
}