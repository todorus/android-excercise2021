package com.todorus.exercise2021.ui.product.detail.items.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import com.todorus.domain.Product
import com.todorus.exercise2021.R
import com.todorus.exercise2021.databinding.ItemProductProductBinding
import com.todorus.exercise2021.ui.product.detail.items.ProductDetailItem

class ProductViewHolder(itemView: View): ItemViewHolder(itemView) {

    companion object {
        fun create(parent: ViewGroup): ProductViewHolder {
            val inflater: LayoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemProductProductBinding =
                DataBindingUtil.inflate(inflater, R.layout.item_product_product, parent, false)
            val viewHolder = ProductViewHolder(binding.root)
            binding.viewModel = viewHolder

            return viewHolder
        }
    }

    override val type: ProductDetailItem.Type = ProductDetailItem.Type.PRODUCT

    override fun bind(data: ProductDetailItem) {
        product = data.product
    }

    var product: Product? = null
        set(value) {
            field = value
            notifyChange()
        }

    @get:Bindable
    val title: String?
        get() = product?.title

    @get:Bindable
    val price: String?
        get() = product?.offerData?.offers?.first()
            ?.price.toString()

    @get:Bindable
    val description: String?
        get() = product?.shortDescription

    @get:Bindable
    val rating: Int?
        get() = product?.rating

    @get:Bindable
    val mediaUrls: List<String>?
        get() = product?.media?.map { it.url!! }
}