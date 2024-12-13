package com.example.quantom.composes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quantom.R

val vazirThinFont = FontFamily(
    Font(R.font.vazirmedium)
)
val vazirThinFont2 = FontFamily(
    Font(R.font.vazirlight)
)
val vazirThinFont3 = FontFamily(
    Font(R.font.vazirthin)
)

@Composable
fun ContentJavayez() {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 50.dp, bottom = 16.dp) // Adds padding at the top and bottom
    ) {
        item {
            Part1J()
        }
        item {
            Spacer(modifier = Modifier.height(20.dp))
        }
        item {
            Box (contentAlignment = Alignment.CenterEnd, modifier = Modifier.fillMaxWidth()){ Text("جوایز",
                style = TextStyle(
                    fontFamily = vazirThinFont,
                    fontSize = 18.sp // Adjust font size as needed
                )) }

        }
        items(4) { // 4 items for images
            Spacer(modifier = Modifier.height(10.dp))
            Image(painter = painterResource(id = R.drawable.ccc), contentDescription = null)
        }
    }
}


@Composable
fun Part1J() {
    Card(modifier = Modifier
        .fillMaxWidth()
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp), verticalAlignment = Alignment.CenterVertically){
            Box (modifier = Modifier.weight(0.3f), contentAlignment = Alignment.Center){
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Text("10000",
                        style = TextStyle(
                            fontFamily = vazirThinFont,
                            fontSize = 18.sp // Adjust font size as needed
                        ))
                }
            }
            Box (modifier = Modifier.weight(0.5f), contentAlignment = Alignment.Center){
                Text("امتیازات من",
                    style = TextStyle(
                        fontFamily = vazirThinFont,
                        fontSize = 18.sp // Adjust font size as needed
                    )
                )
            }
        }
    }
}
