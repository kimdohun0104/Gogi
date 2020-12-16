package com.deepghought.core.theme

import androidx.compose.material.*
import androidx.compose.ui.graphics.Color

val colorBlack100 = Color(0xFF1E1E1E)

val colorRed500 = Color(0xFFF44336)

val colorGray100 = Color(0xFFF5F5F5)
val colorGray200 = Color(0xFFEEEEEE)
val colorGray500 = Color(0xFF9E9E9E)
val colorGray600 = Color(0xFF757575)

val colorBlueGray400 = Color(0xFF78909C)

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

fun Colors.expenditureSection() =
    if (isLight) colorGray100
    else colorBlack100