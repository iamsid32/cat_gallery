package com.app.catgallery

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.airbnb.lottie.compose.*
import com.app.catgallery.model.ImageModel

@Composable
fun LottieLoaderComposable(resource: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        val preloaderLottieComposition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(resource)
        )

        val preloaderProgress by animateLottieCompositionAsState(
            preloaderLottieComposition,
            iterations = LottieConstants.IterateForever,
            isPlaying = true
        )

        LottieAnimation(
            composition = preloaderLottieComposition,
            progress = preloaderProgress,
            modifier = Modifier
                .fillMaxSize(fraction = 1f)
                .background(color = MaterialTheme.colorScheme.secondaryContainer),
        )
    }
}

@Composable
fun CatImageItemComposable(item: ImageModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth()
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                color = MaterialTheme.colorScheme.surfaceColorAtElevation(
                    40.dp
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        val uriHandler = LocalUriHandler.current

        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.url)
                    .crossfade(true)
                    .decoderFactory(ImageDecoderDecoder.Factory())
                    .build(),
                contentDescription = "Cat Image",
                placeholder = painterResource(id = R.drawable.placeholder),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                item.url,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .clickable { uriHandler.openUri(item.url) },
                color = MaterialTheme.colorScheme.outline,
                fontSize = 20.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                textDecoration = TextDecoration.Underline
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}