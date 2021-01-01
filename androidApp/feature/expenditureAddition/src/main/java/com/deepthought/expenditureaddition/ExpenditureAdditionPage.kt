package com.deepthought.expenditureaddition

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.deepghought.core.common.CommonTopBar
import com.deepghought.core.theme.captionRegular
import com.deepghought.core.theme.colorGray500
import com.deepghought.core.theme.paragraph
import com.deepghought.core.theme.paragraphRegular

@Composable
fun ExpenditureAdditionPage(
    viewModel: ExpenditureAdditionViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = {
            ExpenditureAdditionTopBar(viewModel = viewModel, navController = navController)
        }
    ) {
        Column(
            modifier = Modifier.padding(vertical = 24.dp, horizontal = 32.dp)
        ) {

            ExpenditureAdditionNameTextField()
            Box(modifier = Modifier.height(24.dp))
            ExpenditureAdditionPriceTextField()
            Box(modifier = Modifier.height(24.dp))
            ExpenditureAdditionSelectPaymentDay()
            Box(modifier = Modifier.height(24.dp))
            ExpenditureAdditionSelectCategory(navController)
        }

    }
}

@Composable
private fun ExpenditureAdditionTopBar(
    viewModel: ExpenditureAdditionViewModel,
    navController: NavController
) {
    CommonTopBar(
        title = "지출 추가",
        navigationIcon = R.drawable.ic_close,
        onClickNavigation = { navController.popBackStack() },
        action = "확인"
    )
}

@Composable
private fun ExpenditureAdditionNameTextField() {
    TextField(
        value = "",
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.paragraphRegular,
        label = { Text(text = "이름") },
        onValueChange = {

        })
}

@Composable
private fun ExpenditureAdditionPriceTextField() {
    TextField(
        value = "",
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.paragraphRegular,
        label = { Text(text = "금액") },
        onValueChange = {

        })
}

@Composable
private fun ExpenditureAdditionSelectPaymentDay() {
    Text(
        "지출일",
        style = MaterialTheme.typography.captionRegular
            .copy(color = colorGray500)
    )
    Row {
        Text(
            text = "말일",
            style = MaterialTheme.typography.paragraphRegular,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "선택",
            style = MaterialTheme.typography.paragraph
                .copy(color = MaterialTheme.colors.primary)
        )
    }
}

@Composable
private fun ExpenditureAdditionSelectCategory(
    navController: NavController
) {
    Text(
        "분류",
        style = MaterialTheme.typography.captionRegular
            .copy(color = colorGray500)
    )
    Row {
        Text(
            text = "문화/컨텐츠",
            style = MaterialTheme.typography.paragraphRegular,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "선택",
            style = MaterialTheme.typography.paragraph
                .copy(color = MaterialTheme.colors.primary),
            modifier = Modifier.clickable(onClick = {
                navController.navigate("expenditureCategorySelection")
            })
        )
    }
}