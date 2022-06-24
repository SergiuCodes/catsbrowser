package com.example.catsbrowser.data.network.response

import com.google.gson.annotations.SerializedName

data class Image(

    @SerializedName("id")
    var id: String? = null,
    @SerializedName("width")
    var width: Int? = null,
    @SerializedName("height")
    var height: Int? = null,
    @SerializedName("url")
    var url: String? = null
)