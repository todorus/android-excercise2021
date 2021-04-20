package com.todorus.exercise2021.ui.product.detail

import androidx.databinding.Bindable
import com.todorus.domain.Product
import com.todorus.exercise2021.ui.ObservableViewModel
import com.todorus.exercise2021.BR

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
    var title: String? = null
        get() = product?.title

}