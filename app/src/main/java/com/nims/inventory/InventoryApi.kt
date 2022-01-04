package com.nims.inventory

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface InventoryApi {
    @GET("uws/v1/inventory")
    fun getInventory(@Query("serviceKey") serviceKey: String, @Query("page") page: Int, @Query("perPage") perPage: Int, @Query("cond[addr::LIKE]") addr: String): Single<InventoryResponse>
}