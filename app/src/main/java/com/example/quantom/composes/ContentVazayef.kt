package com.example.quantom.composes

import android.content.Intent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.quantom.fragments.DoingTaskFragment
import com.example.quantom.ui.theme.GreenPrimary

@Composable
fun ContentVazayef(){
    Column (modifier = Modifier
        .fillMaxHeight()
        .padding(horizontal = 16.dp)){
        Spacer(modifier = Modifier.height(50.dp))
        Part1Vazayef()
        Spacer(modifier = Modifier.height(20.dp))
        Part2Vazayef("وظایف در حال انقضا")
        Spacer(modifier = Modifier.height(10.dp))
        Part3Vazayef()
        Spacer(modifier = Modifier.height(20.dp))
        Part2Vazayef("وظایف")
        Spacer(modifier = Modifier.height(10.dp))

        Part3Card()
    }
}

@Composable
fun Part1Vazayef() {
    Card(modifier = Modifier
        .fillMaxWidth().clickable {
            val intent = Intent(this,DoingTaskFragment ::class.java)
            startActivity(intent)
        }
        ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp), verticalAlignment = Alignment.CenterVertically){
            Box (modifier = Modifier.weight(0.3f), contentAlignment = Alignment.Center){
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    SimpleCircularProgressBar(
                        percentage = 0.2f, // 60% progress
                        size = 60.dp,
                        strokeWidth = 6.dp,
//                        color = Color.Green
                    )
                    Text("2 از 10",
                        style = TextStyle(
                            fontFamily = vazirThinFont,
                            fontSize = 18.sp // Adjust font size as needed
                        ))
                }
            }
            Box (modifier = Modifier.weight(0.5f), contentAlignment = Alignment.Center){
                Text("وظایف درحال انجام",
                    style = TextStyle(
                        fontFamily = vazirThinFont,
                        fontSize = 18.sp // Adjust font size as needed
                    ))
            }
        }
    }
}

@Composable
fun Part2Vazayef(text:String) {
    Box (modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Box (modifier = Modifier.align(Alignment.CenterStart)){
            Button(onClick = {}) {
                Text("بیشتر",
                    style = TextStyle(
                        fontFamily = vazirThinFont,
                        fontSize = 18.sp // Adjust font size as needed
                    ))
            }
        }
        Box (modifier = Modifier.align(Alignment.CenterEnd)){
            Text(text,
                style = TextStyle(
                    fontFamily = vazirThinFont,
                    fontSize = 18.sp // Adjust font size as needed
                ))
        }
    }
}

@Composable
fun Part3Vazayef() {
    Column {
        Part3Card()
        Spacer(modifier = Modifier.height(8.dp))

        Part3Card()
    }
}

@Composable
fun Part3Card() {
    Card() {
        Spacer(modifier = Modifier.height(8.dp))
        Row (verticalAlignment = Alignment.CenterVertically){
            Box(
                modifier = Modifier.weight(0.16f),
                contentAlignment = Alignment.Center
            ) {
                Column (horizontalAlignment = Alignment.CenterHorizontally) {
                    SimpleCircularProgressBar(
                        percentage = 0.6f, // 60% progress
                        size = 60.dp,
                        strokeWidth = 6.dp,
//                        color = Color.Green
                    )
                    Text("زمان باقی مانده",
                        style = TextStyle(
                            fontFamily = vazirThinFont,
                            fontSize = 14.sp // Adjust font size as needed
                        ))
                }
            }
            Box(modifier = Modifier.weight(0.08f), contentAlignment = Alignment.Center) {
                Column (horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("امتیاز",
                        style = TextStyle(
                            fontFamily = vazirThinFont2,
                            fontSize = 18.sp // Adjust font size as needed
                        ))
                    Text("200",
                        style = TextStyle(
                            fontFamily = vazirThinFont,
                            fontSize = 18.sp // Adjust font size as needed
                        ))
                }
            }
            Box(modifier = Modifier.weight(0.3f), contentAlignment = Alignment.Center) {
                Column (horizontalAlignment = Alignment.End){
                    Text("عنوان وظیفه",
                        style = TextStyle(
                            fontFamily = vazirThinFont2,
                            fontSize = 18.sp // Adjust font size as needed
                        ))
                    Text("توضیحی مختصر راجع به ماموریت",
                        style = TextStyle(
                            fontFamily = vazirThinFont3,
                            fontSize = 13.sp // Adjust font size as needed
                        ), modifier = Modifier.align(Alignment.End)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun SimpleCircularProgressBar(
    percentage: Float, // Value between 0f and 1f
    modifier: Modifier = Modifier,
    size: Dp = 100.dp,
    strokeWidth: Dp = 8.dp,
    color: Color = GreenPrimary
) {
    Canvas(modifier = modifier.size(size).padding(12.dp)) {
        drawArc(
            color = color,
            startAngle = -90f,
            sweepAngle = 360f * percentage,
            useCenter = false,
            style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
        )
    }
}