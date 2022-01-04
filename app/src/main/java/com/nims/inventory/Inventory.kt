package com.nims.inventory

import com.google.gson.annotations.SerializedName

data class InventoryResponse(
    @SerializedName("currentCount")
    val currentCount: Int,
    @SerializedName("matchCount")
    val matchCount: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("perPage")
    val perPage: Int,
    @SerializedName("totalCount")
    val totalCount: Int,
    @SerializedName("data")
    val data: ArrayList<Inventory>
)

data class Inventory(
    @SerializedName("addr")
    val addr: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("inventory")
    val inventory: String,
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("openTime")
    val openTime: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("regDt")
    val regDt: String,
    @SerializedName("tel")
    val tel: String,
    @SerializedName("color")
    val color: String
)