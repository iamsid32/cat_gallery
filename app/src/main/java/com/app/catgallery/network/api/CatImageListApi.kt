package com.app.catgallery.network.api

import com.app.catgallery.model.CatImageModel
import com.app.catgallery.model.ImageModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatImageListApi {

    @GET("images/search")
    suspend fun getCatImageList(
        @Query("limit") limit: Int? = 10,
    ): Response<MutableList<ImageModel>>

}