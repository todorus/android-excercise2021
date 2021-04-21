package com.todorus.exercise2021.ui.product.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.todorus.exercise2021.R
import com.todorus.exercise2021.api
import com.todorus.exercise2021.databinding.MainFragmentBinding
import com.todorus.exercise2021.ui.product.detail.items.ProductDetailAdapter
import com.todorus.exercise2021.ui.product.detail.media.MediaAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import java.lang.Exception

class ProductDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ProductDetailFragment()
    }

    private lateinit var viewModel: ProductDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        viewModel = ViewModelProvider(this).get(ProductDetailViewModel::class.java)

        val binding: MainFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        binding.viewModel = viewModel
        binding.list.adapter = ProductDetailAdapter(childFragmentManager, lifecycle) // TODO check for circular dependency
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
    }

    private fun fetchData() {
        viewModel.error = null
        viewModel.loading = true
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            try {
                val productResult = context?.api?.productService?.get("9200000028828094")!!
                val recommendationResult =
                    context?.api?.productService?.getRecommendations("9200000028828094")!!
                val accessoriesResult =
                    context?.api?.productService?.getRelated("9200000028828094")!!
                Timber.d("got data")
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                    viewModel.product = productResult.products.first()
                    viewModel.recommendations = recommendationResult.products
                    viewModel.accessories = accessoriesResult.products
                    viewModel.loading = false
                }
            } catch (e: Exception) {
                // TODO blocks for specific exceptions
                Timber.w(e, "Could not fetch data")
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                    viewModel.error = "Could not fetch data"
                    viewModel.loading = false
                }
            }
        }

    }

}