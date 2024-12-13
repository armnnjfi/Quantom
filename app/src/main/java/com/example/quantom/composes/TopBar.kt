package com.example.quantom.composes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBar() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF329664), // First color (#329664)
                        Color(0xFF64C896)  // Second color (#64C896)
                    )
                )
            )
        , contentAlignment = Alignment.BottomEnd
    ){
        Row (modifier = Modifier.fillMaxWidth()){
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.BottomCenter){
                TopBarTextt("جوایز")
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.BottomCenter){
                TopBarTextt("وظایف")
            }
        }
    }
}

@Composable
fun TopBarTextt(txt:String) {
    Text(txt, color = Color.White, modifier = Modifier.padding(end = 8.dp))
}