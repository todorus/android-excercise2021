package com.todorus.exercise2021

import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.todorus.exercise2021.ui.product.detail.media.MediaAdapter
import timber.log.Timber


@BindingAdapter("imageUrls")
fun setImages(view: ViewPager2, value: List<String>?) {
    if(view.adapter !is MediaAdapter) {
        Timber.w("Tried to set image urls to a non MediaAdapter")
        return
    }
    (view.adapter as MediaAdapter).data = value
}