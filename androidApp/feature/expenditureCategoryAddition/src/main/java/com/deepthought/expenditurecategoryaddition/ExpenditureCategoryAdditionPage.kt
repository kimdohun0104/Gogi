package com.deepthought.expenditurecategoryaddition

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.deepghought.core.common.CommonTopBar
import com.deepghought.core.theme.paragraphRegular

@Composable
fun ExpenditureCategoryAdditionPage(
    viewModel: ExpenditureCategoryAdditionViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = { ExpenditureCategoryAdditionTopBar(navController = navController) }
    ) {
        Column(
            modifier = Modifier.padding(vertical = 24.dp, horizontal = 31.dp)
        ) {
            ExpenditureCategoryAdditionNameTextField()
        }
    }
}

@Composable
private fun ExpenditureCategoryAdditionTopBar(navController: NavController) {
    CommonTopBar(
        title = "분류 추가",
        navigationIcon = R.drawable.ic_left_arrow,
        onClickNavigation = { navController.popBackStack() },
        action = "완료",
        onClickAction = { }
    )
}

@Composable
private fun ExpenditureCategoryAdditionNameTextField() {
    TextField(
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        value = "",
        textStyle = MaterialTheme.typography.paragraphRegular,
        label = { Text(text = "이름") },
        onValueChange = {

        })
}