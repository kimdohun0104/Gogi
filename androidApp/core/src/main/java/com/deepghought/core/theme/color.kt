package com.deepghought.core.theme

import androidx.compose.material.*
import androidx.compose.ui.graphics.Color

val colorBlack100 = Color(0xFF1E1E1E)

val colorRed500 = Color(0xFFF44336)

val colorGray100 = Color(0xFFF5F5F5)
val colorGray200 = Color(0xFFEEEEEE)
val colorGray500 = Color(0xFF9E9E9E)
val colorGray600 = Color(0xFF757575)
val colorGray800 = Color(0xFF424242)
val colorGray900 = Color(0xFF212121)

val colorBlueGray400 = Color(0xFF78909C)

val DarkColors = darkColors(

)

val LightColors = lightColors(

)

val Colors.white: Color
    get() = if (isLight) Color.White
    else Color.Black

val Colors.black: Color
    get() = if (isLight) Color.Black
    else Color.White

val Colors.topAppBar: Color
    get() = if (isLight) Color.White
    else Color(0xFF202020)

val Colors.expenditureSection: Color
    get() = if (isLight) colorGray100
    else colorBlack100

val Colors.secondaryUnselected: Color
    get() = Color(0xFF02877A)

val Colors.divider: Color
    get() = if (isLight) colorGray200
    else colorGray900