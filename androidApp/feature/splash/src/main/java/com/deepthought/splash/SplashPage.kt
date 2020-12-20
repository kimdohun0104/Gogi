package com.deepthought.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.deepghought.core.ext.event
import com.deepghought.core.theme.black

@Composable
fun SplashPage(
    viewModel: SplashViewModel,
    navController: NavController,
) {
    viewModel.event {
        navigateHome.getData()?.let {
            navController.navigate("home")
        }

        navigateInputName.getData()?.let {
            navController.navigate("inputName")
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Gogi",
            style = MaterialTheme.typography.h1
                .copy(color = MaterialTheme.colors.black)
        )
    }
}