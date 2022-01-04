package com.nims.inventory

import android.app.Application
import androidx.multidex.MultiDex
import com.nims.inventory.di.apiModule
import com.nims.inventory.di.networkModule
import com.nims.inventory.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        startKoin(this, listOf(
            apiModule,
            networkModule,
            viewModelModule
        ))
    }
}