package com.app.catgallery.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.catgallery.model.ImageModel
import com.app.catgallery.network.repository.CatImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatImageViewModel @Inject constructor(
    private val catImageRepository: CatImageRepository
) : ViewModel() {

    val catImageList = MutableLiveData<MutableList<ImageModel>>()
    val showLoader = MutableLiveData<Boolean>(false)

    fun getCatImageList(limit:Int = 10){
        viewModelScope.launch {
            showLoader.postValue(true)
            val response  = catImageRepository.getCatImageList(limit)
            if (response.isSuccessful){
                catImageList.postValue(response.body())
            }
            if (!response.isSuccessful){
                Log.e("API_ERROR","${response.errorBody()}")
            }
            showLoader.postValue(false)
        }
    }

}