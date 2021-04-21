package com.todorus.exercise2021.ui.product.detail.items.viewholders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.todorus.domain.Product
import com.todorus.exercise2021.R
import com.todorus.exercise2021.databinding.ItemProductHeaderBinding
import com.todorus.exercise2021.ui.product.detail.items.ProductDetailItem
import com.todorus.exercise2021.ui.product.detail.items.ProductHeaderItem
import com.todorus.exercise2021.ui.product.detail.media.MediaAdapter

class HeaderViewHolder(itemView: View): ItemViewHolder(itemView) {

    companion object {
        fun create(parent: ViewGroup, fragmentManager: FragmentManager, lifecycle: Lifecycle): HeaderViewHolder {
            val inflater: LayoutInflater = LayoutInflater.from(parent.context)
            val binding: ItemProductHeaderBinding = DataBindingUtil.inflate(inflater, R.layout.item_product_header, parent, false)
            val viewHolder = HeaderViewHolder(binding.root)
            binding.viewModel = viewHolder
            binding.header.adapter = MediaAdapter(fragmentManager, lifecycle)

            return viewHolder
        }
    }

    override val type: ProductDetailItem.Type = ProductDetailItem.Type.HEADER

    override fun bind(data: ProductDetailItem) {
        product = (data as ProductHeaderItem).product
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