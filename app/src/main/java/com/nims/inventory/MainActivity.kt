package com.nims.inventory

import android.os.Bundle
import android.view.ViewGroup
import com.nims.inventory.core.BindingActivity
import com.nims.inventory.databinding.ActivityMainBinding
import net.daum.mf.map.api.MapView
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BindingActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = getViewModel()
        binding.lifecycleOwner = this
        val mapView = MapView(this)
        val mapViewContainer = binding.mapView as ViewGroup
        mapViewContainer.addView(mapView)
        binding.vm?.fetchInventory(this)
    }

    override fun getLayoutResId(): Int = R.layout.activity_main
}