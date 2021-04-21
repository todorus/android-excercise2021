package com.todorus.exercise2021.ui.product.detail.items.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import com.todorus.exercise2021.BR
import com.todorus.exercise2021.R
import com.todorus.exercise2021.databinding.ItemProductLoadingBinding
import com.todorus.exercise2021.databinding.ItemProductTitleBinding
import com.todorus.exercise2021.ui.product.detail.items.ProductDetailItem
import com.todorus.exercise2021.ui.product.detail.items.ProductTitleItem

class LoadingViewHolder(itemView: View): ItemViewHolder(itemView) {

    companion object {
        fun create(parent: ViewGroup): LoadingViewHolder {
            val inflater: LayoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemProductLoadingBinding =
                DataBindingUtil.inflate(inflater, R.layout.item_product_loading, parent, false)
            val viewHolder = LoadingViewHolder(binding.root)

            return viewHolder
        }
    }

    override val type: ProductDetailItem.Type = ProductDetailItem.Type.LOADER

    override fun bind(data: ProductDetailItem) {}

}