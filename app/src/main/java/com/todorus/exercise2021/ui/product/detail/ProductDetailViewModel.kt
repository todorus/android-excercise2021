package com.todorus.exercise2021.ui.product.detail

import androidx.databinding.Bindable
import com.todorus.domain.Product
import com.todorus.exercise2021.BR
import com.todorus.exercise2021.R
import com.todorus.exercise2021.ui.product.detail.items.ProductDetailItem
import com.todorus.exercise2021.ui.product.detail.items.ProductHeaderItem
import com.todorus.exercise2021.ui.product.detail.items.ProductProductItem
import com.todorus.exercise2021.ui.product.detail.items.ProductTitleItem
import com.todorus.exercise2021.ui.product.observables.ObservableViewModel

class ProductDetailViewModel : ObservableViewModel() {



    @get:Bindable
    var loading: Boolean = true
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }

    @get:Bindable
    var error: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.error)
        }

    var product: Product? = null
        set(value) {
            field = value
            notifyChange()
        }

    var recommendations: List<Product>? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.items)
        }

    var accessories: List<Product>? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.items)
        }

    @get:Bindable
    val items: List<ProductDetailItem>
        get() {
            val all: MutableList<ProductDetailItem> = mutableListOf()

            product?.let {
                all.add(ProductHeaderItem(it))
            }

            recommendations?.let {
                all.addProducts(it, R.string.productdetail_title_recommended)
            }
            accessories?.let {
                all.addProducts(it, R.string.productdetail_title_accessories)
            }

            return all
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

    fun MutableList<ProductDetailItem>.addProducts(products: List<Product>, headerStringResource: Int) {
        this.add(ProductTitleItem(headerStringResource))
        this.addAll(products.map { ProductProductItem(it) })
    }

}