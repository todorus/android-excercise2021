package com.todorus.exercise2021.ui.product.detail.media

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MediaAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {

    var data: List<String>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun createFragment(position: Int): Fragment {
        val url = data!![position]
        return RemoteImageFragment.create(url)
    }
}