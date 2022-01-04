package com.nims.inventory

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.nims.inventory.core.BaseViewModel
import com.nims.inventory.extension.with

class MainViewModel(private val inventoryApi: InventoryApi) : BaseViewModel() {

    private val _inventoryList: NotNullMutableLiveData<List<Inventory>> = NotNullMutableLiveData(arrayListOf())
    val inventoryList: LiveData<List<Inventory>> get() = _inventoryList

    private var page: Int = 1
    private var fetching: Boolean = false
    var updateList: MutableList<Inventory> = mutableListOf()
    fun fetchInventory(context: Context?) {
        synchronized(fetching){
            if (fetching || context == null) {
                return
            }
            fetching = true

            val serviceKey = BuildConfig.INVENTORY_API_KEY
            val perPage = 0
            addToDisposable(
                inventoryApi.getInventory(serviceKey, page, perPage, "")
                    .with()
                    .doOnError {
                        it.printStackTrace()
                    }
                    .subscribe(
                    {
                        if (it.currentCount == 0) {
                            _inventoryList.postValue(updateList)
                            return@subscribe
                        }
                        updateList.addAll(it.data)
                        page++
                        fetching = false
                        fetchInventory(context)
                    },{
                        it.printStackTrace()
                    }
                )
            )
        }
    }
}