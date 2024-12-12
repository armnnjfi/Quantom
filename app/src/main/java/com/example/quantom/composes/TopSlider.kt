package com.example.quantom.composes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun GlideImageScreen(img:String) {
        GlideImage(
            model = img,
            contentDescription = "",
            modifier = Modifier,
            contentScale = ContentScale.Crop
        )
}

@Preview
@Composable
fun TopSlider(
    modifier: Modifier = Modifier
) {
    Column {
        val images = listOf(
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.ABNnvjDbp7BCBRqFwC7rSQHaFK%26pid%3DApi&f=1&ipt=3ed341074aac836b760452a613ad4d0472cf6c85dbb4da98b3c83fa3b37fab2f&ipo=images",
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.E9CbzRVrJkewyhpgKoocggHaFS%26pid%3DApi&f=1&ipt=5d8722f0075b701920139139d8d6b376985b565bc2cbda8ed2a754c3394a4064&ipo=images",
            "https://idc0-cdn0.khamenei.ir/ndata/home/1403/140309211549b070b.jpg",
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.G59kgNr7hc5fIjkdePwcXwHaFE%26pid%3DApi&f=1&ipt=24bfeac08a83ff61db85b795690fb7825d7c457d157a7ef69ccaea9976ce3e65&ipo=images"
        )

        ImageSlider(images)
    }
}





@Composable
fun ImageSlider(images: List<Any>) {
    var currentImageIndex by remember { mutableIntStateOf(0) }
    var isAnimating by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.weight(1f).height(100.dp)
            .fillMaxWidth().padding(16.dp)) {
            // Scrollable Row of Cards
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                itemsIndexed(images) { index, image ->
                    Card(
                        modifier = Modifier
                            .width(300.dp)
                            .height(200.dp)
                            .clickable {
                                if (index != currentImageIndex && !isAnimating) {
                                    isAnimating = true
                                    coroutineScope.launch {
                                        val delayMillis = 500L
                                        // Wait for the card to change color before animating
                                        delay(delayMillis / 2)
                                        currentImageIndex = index
                                        delay(delayMillis)
                                        isAnimating = false
                                    }
                                }
                            },
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        GlideImageScreen(
                            img = image as String,

                        )
                    }
                }

            }

        }
    }
    // Automatic Image Slider
    LaunchedEffect(currentImageIndex) {
        while (true) {
            delay(5000L)
            if (!isAnimating) {
                val nextIndex = (currentImageIndex + 1) % images.size
                currentImageIndex = nextIndex
            }
        }
    }
}
