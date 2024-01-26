package com.app.catgallery.network.repository

import com.app.catgallery.model.ImageModel
import com.app.catgallery.network.api.CatImageListApi
import retrofit2.Response
import javax.inject.Inject

class CatImageRepository @Inject constructor(
    private val catImageListApi: CatImageListApi,
) {

    suspend fun getCatImageList(limit: Int): Response<MutableList<ImageModel>> {
        return catImageListApi.getCatImageList(10)
    }

}