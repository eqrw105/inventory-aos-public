package com.nims.inventory.di

import com.nims.inventory.InventoryApi
import org.koin.dsl.module.module
import retrofit2.Retrofit

val apiModule = module {
    single(createOnStart = false) { get<Retrofit>().create(InventoryApi::class.java) }
}