package com.nfragiskatos.news_api_client.data.model


import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    val id: Any,
    @SerializedName("name")
    val name: String
)