package com.deepthought.core.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val gogiTypography = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    )
)

val Typography.paragraph: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )


val Typography.paragraphRegular: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )


val Typography.captionRegular: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
