package com.todorus.exercise2021

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.todorus.exercise2021.ui.product.detail.items.ProductDetailAdapter
import com.todorus.exercise2021.ui.product.detail.items.ProductDetailItem
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

@BindingAdapter("productDetailItems")
fun setProductDetailItems(view: RecyclerView, value: List<ProductDetailItem>?) {
    if(view.adapter !is ProductDetailAdapter) {
        Timber.w("Tried to set productDetailItems to a non ProductDetailAdapter")
        return
    }
    (view.adapter as ProductDetailAdapter).data = value
}

@BindingAdapter("textResource")
fun setProductDetailItems(view: TextView, value: Int?) {
    view.text = if(value != null) {
        view.resources.getString(value)
    } else {
        null
    }
}