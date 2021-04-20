package com.todorus.exercise2021.ui.product.detail.media

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.todorus.exercise2021.R
import com.todorus.exercise2021.databinding.RemoteImageFragmentBinding

class RemoteImageFragment: Fragment() {

    companion object {

        const val ARG_URL = "MediaFragment.url"

        fun create(imageUrl: String):RemoteImageFragment {
            val fragment = RemoteImageFragment()
            fragment.arguments = Bundle().apply {
                putString(ARG_URL, imageUrl)
            }
            return fragment
        }
    }

    lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        url = arguments!!.getString(ARG_URL)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: RemoteImageFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.remote_image_fragment, null, false)

        Glide.with(this)
            .load(url)
            .into(binding.image)

        return binding.root
    }

}