package com.todorus.exercise2021.ui.product.detail.items.viewholders

import android.view.View
import com.todorus.exercise2021.ui.product.detail.items.ProductDetailItem
import com.todorus.exercise2021.ui.product.observables.ObservableViewHolder

abstract class ItemViewHolder(itemView: View) : ObservableViewHolder(itemView) {
    abstract val type: ProductDetailItem.Type
    abstract fun bind(data: ProductDetailItem)
}