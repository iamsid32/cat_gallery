package com.app.catgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.*
import com.app.catgallery.ui.theme.CatGalleryTheme
import com.app.catgallery.view_model.CatImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            CatGalleryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CatImageListComposable()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CatImageListComposable(catImageViewModel: CatImageViewModel = hiltViewModel()) {

    LaunchedEffect(key1 = Unit) {
        catImageViewModel.getCatImageList()
    }

    val showLoader by catImageViewModel.showLoader.observeAsState(false)
    val catImageList by catImageViewModel.catImageList.observeAsState()

    val pullRefreshState = rememberPullRefreshState(
        refreshing = showLoader,
        onRefresh = {
            catImageViewModel.getCatImageList()
        }
    )
     Surface(modifier = Modifier.fillMaxSize()) {
         Box(
             modifier = Modifier
                 .fillMaxSize()
                 .pullRefresh(pullRefreshState)
                 .background(color = MaterialTheme.colorScheme.surfaceContainer)
         ) {

             if (catImageList != null){
                 if (catImageList!!.size > 1){
                     LazyColumn(
                         modifier = Modifier.fillMaxSize()
                     ){
                         items(catImageList!!) {item->
                             CatImageItemComposable(item)
                         }
                         item {
                             Spacer(modifier = Modifier.height(20.dp))
                         }
                     }
                 }else{
                     LottieLoaderComposable(R.raw.empty)
                 }
             }else{
                 LottieLoaderComposable(R.raw.loader)
             }

             PullRefreshIndicator(
                 refreshing = showLoader,
                 state =pullRefreshState,
                 modifier = Modifier
                     .padding(top = 20.dp)
                     .align(Alignment.TopCenter),
                 contentColor = MaterialTheme.colorScheme.primary
             )
         }
     }
}
