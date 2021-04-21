package com.todorus.exercise2021.ui.product.detail.items.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import com.todorus.exercise2021.BR
import com.todorus.exercise2021.R
import com.todorus.exercise2021.databinding.ItemProductTextBinding
import com.todorus.exercise2021.databinding.ItemProductTitleBinding
import com.todorus.exercise2021.ui.product.detail.items.ProductDetailItem
import com.todorus.exercise2021.ui.product.detail.items.ProductTitleItem

class TextViewHolder(itemView: View): ItemViewHolder(itemView) {

    companion object {
        fun create(parent: ViewGroup): TextViewHolder {
            val inflater: LayoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemProductTextBinding =
                DataBindingUtil.inflate(inflater, R.layout.item_product_text, parent, false)
            val viewHolder = TextViewHolder(binding.root)
            binding.viewModel = viewHolder

            return viewHolder
        }
    }

    override val type: ProductDetailItem.Type = ProductDetailItem.Type.TEXT

    override fun bind(data: ProductDetailItem) {
        titleRes = (data as ProductTitleItem).stringResource
        notifyChange()
    }

    @get:Bindable
    var titleRes: Int? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

}