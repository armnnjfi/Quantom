package com.example.quantom.composes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quantom.ui.theme.QuantomTheme

@Preview
@Composable
fun Javayez(
    modifier: Modifier = Modifier
) {
    val isVazayefVisible = remember { mutableStateOf(false) } // State to track visibility

    QuantomTheme {
        Column(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopBar(isVazayefVisible) // Passing state to TopBar
            if (isVazayefVisible.value) {
                ContentJavayez()
            }
            else{
                ContentVazayef() // Only show ContentVazayef when state is true
            }
        }
    }
}

@Composable
fun TopBar(isVazayefVisible: MutableState<Boolean>) {
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
            ),
        contentAlignment = Alignment.BottomEnd
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        isVazayefVisible.value = true // Hide ContentVazayef when "جوایز" is clicked
                    }
                    .padding(8.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                TopBarText("جوایز")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        isVazayefVisible.value = false // Show ContentVazayef when "وظایف" is clicked
                    }
                    .padding(8.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                TopBarText("وظایف")
            }
        }
    }
}

@Composable
fun TopBarText(txt: String) {
    Text(txt, color = Color.White)
}