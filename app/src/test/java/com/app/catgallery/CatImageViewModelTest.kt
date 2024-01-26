import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.app.catgallery.model.ImageModel
import com.app.catgallery.network.repository.CatImageRepository
import com.app.catgallery.view_model.CatImageViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CatImageViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catImageRepository: CatImageRepository

    private lateinit var viewModel: CatImageViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = CatImageViewModel(catImageRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun getCatImageList_success() = runBlockingTest {
        // Mock setup
        val mockData = mock<MutableList<ImageModel>>()
        val response = Response.success(mockData)
        whenever(catImageRepository.getCatImageList(any())).thenReturn(response)

        // LiveData observation
        val observer: Observer<MutableList<ImageModel>> = mock()
        viewModel.catImageList.observeForever(observer)

        // Action
        viewModel.getCatImageList()

        // Verification
        verify(observer).onChanged(mockData)
        assert(viewModel.showLoader.value == false)
    }

    @Test
    fun getCatImageList_failure() = runBlockingTest {
        // Mock the repository call to return a failure
        val response: Response<MutableList<ImageModel>> = Response.error(404, mock())
        whenever(catImageRepository.getCatImageList(any())).thenReturn(response)

        // Observe the LiveData
        val observer: Observer<Boolean> = mock()
        viewModel.showLoader.observeForever(observer)

        // Trigger
        viewModel.getCatImageList()

        // Verify
        verify(observer).onChanged(false) // Loader should be hidden on failure
    }
}

