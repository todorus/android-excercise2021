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
import com.todorus.exercise2021.ui.product.detail.media.MediaAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        binding.header.adapter = MediaAdapter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
    }

    private fun fetchData() {
        viewModel.loading = true

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            val result = context?.api?.productService?.get("9200000028828094")!!
            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
                viewModel.product = result.products.first()
                viewModel.loading = false
            }
        }
    }

}