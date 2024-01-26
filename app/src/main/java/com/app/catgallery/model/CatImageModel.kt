package com.app.catgallery.model

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class CatImageModel(
    val imageList:MutableList<ImageModel> ?= null
)

@Keep
@JsonClass(generateAdapter = true)
data class ImageModel (
    @Json(name = "id")
    val id: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "width")
    val width: Long,
    @Json(name = "height")
    val height: Long
)
