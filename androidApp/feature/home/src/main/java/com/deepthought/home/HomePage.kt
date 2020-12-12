package com.deepthought.home

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.deepthought.home.component.HomeHeader

@Composable
fun HomePage(
    viewModel: HomeViewModel,
    navController: NavController
) {
    ScrollableColumn {
        HomeHeader(viewModel)
    }
}

