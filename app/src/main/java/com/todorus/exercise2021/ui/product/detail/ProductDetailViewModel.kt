package com.todorus.exercise2021.ui.product.detail

import android.view.View
import androidx.databinding.Bindable
import com.todorus.domain.Product
import com.todorus.exercise2021.BR
import com.todorus.exercise2021.R
import com.todorus.exercise2021.ui.product.detail.items.*
import com.todorus.exercise2021.ui.product.observables.ObservableViewModel

class ProductDetailViewModel : ObservableViewModel() {

    @get:Bindable
    var loading: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
            notifyPropertyChanged(BR.ready)
        }

    var accessoriesLoading: Boolean = false
    var recommendationsLoading: Boolean = false

    @get:Bindable
    val ready: Boolean
        get() = !loading && error == null

    @get:Bindable
    var favorite: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.favorite)
        }

    @get:Bindable
    var onFavClick: View.OnClickListener? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.onFavClick)
        }

    var onAddToCartClick: View.OnClickListener? = null
        set(value) {
            field = value
            notifyChange()
        }

    @get:Bindable
    var error: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.error)
            notifyPropertyChanged(BR.ready)
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

            all.addProductBlock(
                recommendations,
                recommendationsLoading,
                R.string.productdetail_title_recommended,
                R.string.productdetail_error_no_recommendations
            )

            all.addProductBlock(
                accessories,
                accessoriesLoading,
                R.string.productdetail_title_accessories,
                R.string.productdetail_error_no_acessories
            )

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

    fun MutableList<ProductDetailItem>.addTitle(stringResource: Int) =
        this.add(ProductTitleItem(stringResource))

    fun MutableList<ProductDetailItem>.addText(stringResource: Int) =
        this.add(ProductTextItem(stringResource))

    fun MutableList<ProductDetailItem>.addLoader() =
        this.add(ProductLoadingItem())

    fun MutableList<ProductDetailItem>.addProducts(products: List<Product>) =
        this.addAll(products.map { ProductProductItem(it) })

    fun MutableList<ProductDetailItem>.addProductBlock(products: List<Product>?, isLoading: Boolean, titleStringResource: Int, errorStringResource: Int) {
        this.addTitle(titleStringResource)

        if(isLoading) {
            this.addLoader()
        } else if(!products.isNullOrEmpty()) {
            this.addProducts(products)
        } else {
            this.addText(errorStringResource)
        }
    }

}