package com.app.catgallery

import com.app.catgallery.model.ImageModel
import com.app.catgallery.network.api.CatImageListApi
import com.app.catgallery.network.repository.CatImageRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CatImageRepositoryTest {

    @Mock
    private lateinit var catImageListApi: CatImageListApi

    private lateinit var catImageRepository: CatImageRepository

    @Before
    fun setUp() {
        catImageRepository = CatImageRepository(catImageListApi)
    }

    @Test
    fun getCatImageList_success() = runBlockingTest {
        // Define what we expect as a response from the API
        val expectedResponse = mock<MutableList<ImageModel>>()

        // When the API is called with any Int parameter, return a successful response
        whenever(catImageListApi.getCatImageList(any())).thenReturn(Response.success(expectedResponse))

        // Call the repository function
        val result = catImageRepository.getCatImageList(10)

        // Check if the result matches the expected success response
        assertEquals(expectedResponse, result.body())
    }

    @Test
    fun getCatImageList_failure() = runBlockingTest {
        // Simulate an API failure response
        val errorCode = 404
        val errorResponse: Response<MutableList<ImageModel>> = Response.error(errorCode, mock())

        // When the API is called with any Int parameter, return a failure response
        whenever(catImageListApi.getCatImageList(any())).thenReturn(errorResponse)

        // Call the repository function
        val result = catImageRepository.getCatImageList(10)

        // Verify the result is the expected error response
        assertEquals(false, result.isSuccessful)
        assertEquals(errorCode, result.code())
    }
}
