package com.todorus.exercise2021.ui.product.detail

import androidx.databinding.Bindable
import com.todorus.domain.Product
import com.todorus.exercise2021.BR
import com.todorus.exercise2021.ui.ObservableViewModel

class ProductDetailViewModel : ObservableViewModel() {



    @get:Bindable
    var loading: Boolean = true
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
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

    var recommended: List<Product>? = null

    var accessories: List<Product>? = null


}