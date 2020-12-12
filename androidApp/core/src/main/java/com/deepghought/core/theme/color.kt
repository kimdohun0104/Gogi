package com.deepthought.gogi.androidApp.ui.theme

import androidx.compose.material.*
import androidx.compose.ui.graphics.Color

val colorRed500 = Color(0xFFF44336)

val colorGray600 = Color(0xFF757575)

val DarkColors = darkColors(

)

val LightColors = lightColors(

)

fun Colors.white() =
    if (isLight) Color.White
    else Color.Black

fun Colors.black() =
    if (isLight) Color.Black
    else Color.White

fun Colors.topAppBar() =
    if (isLight) Color.White
    else Color(0xFF202020)