package com.nims.inventory

import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

@BindingAdapter(value = ["inventorys", "viewModel"])
fun setInventorys(view: RelativeLayout, items: List<Inventory>, viewModel: MainViewModel) {
    items.filter { it.color != "GRAY" }.forEach {
        val marker = MapPOIItem().apply {
            itemName = it.name
            mapPoint =
                MapPoint.mapPointWithGeoCoord(it.lat.toDouble(), it.lng.toDouble())
            tag = 0
            markerType = when (it.color) {
                "RED" -> MapPOIItem.MarkerType.RedPin
                "YELLOW" -> MapPOIItem.MarkerType.YellowPin
                else -> MapPOIItem.MarkerType.BluePin
            }
            userObject = it
        }
        (view.getChildAt(0) as? MapView)?.addPOIItem(marker)
    }
}

@BindingAdapter(value = ["onScrollListener"])
fun setOnScrollListener(view: RecyclerView, onScrollListener: RecyclerView.OnScrollListener) {
    view.addOnScrollListener(onScrollListener)
}