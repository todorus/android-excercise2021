package com.todorus.exercise2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.todorus.exercise2021.ui.product.detail.ProductDetailFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ProductDetailFragment.newInstance())
                    .commitNow()
        }
    }
}