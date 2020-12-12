package com.deepthought.gogi.androidApp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun GogiTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (isSystemInDarkTheme()) DarkColors else LightColors,
        typography = gogiTypography,
        content = content
    )
}