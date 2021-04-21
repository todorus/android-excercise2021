package com.todorus.exercise2021.ui.product.detail.items

import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.todorus.exercise2021.ui.product.detail.items.viewholders.HeaderViewHolder
import com.todorus.exercise2021.ui.product.detail.items.viewholders.ItemViewHolder
import com.todorus.exercise2021.ui.product.detail.items.viewholders.ProductViewHolder
import timber.log.Timber

class ProductDetailAdapter(val fragmentManager: FragmentManager, val lifecycle: Lifecycle): RecyclerView.Adapter<ItemViewHolder>() {

    var data: List<ProductDetailItem>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val type = ProductDetailItem.Type.values()[viewType]
        return when(type) {
            ProductDetailItem.Type.HEADER -> HeaderViewHolder.create(parent, fragmentManager, lifecycle)
            ProductDetailItem.Type.PRODUCT -> ProductViewHolder.create(parent)
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun getItemViewType(position: Int): Int {
        val item = data!![position]
        try {
            return item.type.ordinal
        } catch (e: NullPointerException) {
            Timber.e("Unknown ViewType")
            throw(e)
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(data!![position])
    }
}