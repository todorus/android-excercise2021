package com.todorus.exercise2021.ui.product.detail.items.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import com.todorus.exercise2021.BR
import com.todorus.exercise2021.R
import com.todorus.exercise2021.databinding.ItemProductTitleBinding
import com.todorus.exercise2021.ui.product.detail.items.ProductDetailItem
import com.todorus.exercise2021.ui.product.detail.items.ProductTitleItem

class TitleViewHolder(itemView: View): ItemViewHolder(itemView) {

    companion object {
        fun create(parent: ViewGroup): TitleViewHolder {
            val inflater: LayoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemProductTitleBinding =
                DataBindingUtil.inflate(inflater, R.layout.item_product_title, parent, false)
            val viewHolder = TitleViewHolder(binding.root)
            binding.viewModel = viewHolder

            return viewHolder
        }
    }

    override val type: ProductDetailItem.Type = ProductDetailItem.Type.PRODUCT

    override fun bind(data: ProductDetailItem) {
        titleRes = (data as ProductTitleItem).stringResource
    }

    @get:Bindable
    var titleRes: Int? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

}