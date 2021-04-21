package com.todorus.exercise2021.ui.product.detail

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.todorus.domain.Product
import com.todorus.exercise2021.R
import com.todorus.exercise2021.analytics
import com.todorus.exercise2021.api
import com.todorus.exercise2021.databinding.MainFragmentBinding
import com.todorus.exercise2021.ui.product.detail.items.ProductDetailAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber


class ProductDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ProductDetailFragment()
    }

    private lateinit var viewModel: ProductDetailViewModel
    private val productId = "9200000056275116"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(ProductDetailViewModel::class.java)
        viewModel.onFavClick = onFavClick
        viewModel.onAddToCartClick = onAddToCartClick

        val binding: MainFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )
        activity?.setActionBar(binding.toolbar)
        binding.viewModel = viewModel
        binding.list.adapter = ProductDetailAdapter(childFragmentManager, lifecycle) // TODO check for circular dependency


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.analytics?.event("ProductDetail.Enter", productId)
        fetchData(productId)
    }

    val onFavClick = View.OnClickListener {
        viewModel.favorite = !viewModel.favorite

        val event = if(viewModel.favorite) {
            "Favorited"
        } else {
            "Unfavorited"
        }
        context?.analytics?.event("ProductDetail.$event", productId)
    }

    val onAddToCartClick = View.OnClickListener {
        Toast.makeText(context, "Added product to basket", Toast.LENGTH_SHORT)
            .show()
        context?.analytics?.event("ProductDetail.AddedToCart", productId)
    }

    private fun fetchData(productId: String) {
        fetchProduct(productId)
        fetchRecommended(productId)
        fetchAccessories(productId)
    }

    private fun fetchProduct(productId: String) {
        viewModel.error = null
        viewModel.loading = true
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            try {
                val productResult = context?.api?.productService?.get(productId)!!

                Timber.d("got data")
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                    viewModel.product = productResult.products.first()
                    viewModel.loading = false
                }
            } catch (e: Exception) {
                Timber.w(e, "Could not fetch data")
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                    viewModel.error = "Could not fetch data"
                    viewModel.loading = false
                }
            }
        }
    }

    private fun fetchRecommended(productId: String) {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            viewModel.recommendationsLoading = true
        }

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            try {
                val recommendationResult =
                    context?.api?.productService?.getRecommendations(productId)!!
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                    viewModel.recommendations = recommendationResult.products
                    viewModel.recommendationsLoading = false
                }
            } catch (e: Exception) {
                Timber.w(e, "Could not fetch data")
            }
        }
    }

    private fun fetchAccessories(productId: String) {
        viewModel.accessoriesLoading = true
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            try {
                val accessoriesResult =
                    context?.api?.productService?.getRelated(productId)!!
                val accessoryProducts: MutableList<Product> = mutableListOf()
                accessoriesResult.accessories.forEach { accessory ->
                    try {
                        val product = context?.api?.productService?.get(accessory.productId)
                        product?.let { result -> accessoryProducts.add(result.products.first()) }
                    } catch (e: Exception) {
                        Timber.w(e, "Could not fetch accessory data")
                    }
                }
                Timber.d("got accessories")
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                    viewModel.accessories = accessoryProducts
                    viewModel.accessoriesLoading = false
                }
            } catch (e: Exception) {
                Timber.w(e, "Could not fetch data")
            }
        }
    }
}