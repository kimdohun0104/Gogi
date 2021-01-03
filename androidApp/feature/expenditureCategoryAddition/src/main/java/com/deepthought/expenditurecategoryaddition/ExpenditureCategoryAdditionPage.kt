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
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.deepthought.core.common.CommonTopBar
import com.deepthought.core.ext.event
import com.deepthought.core.ext.state
import com.deepthought.core.theme.paragraphRegular

@Composable
fun ExpenditureCategoryAdditionPage(
    viewModel: ExpenditureCategoryAdditionViewModel,
    navController: NavController
) {
    viewModel.event {
        it.popBackStack.getData()?.let {
            navController.navigate("expenditureCategorySelection") {
                popUpTo("expenditureAddition") {}
            }
        }
    }

    Scaffold(
        topBar = {
            ExpenditureCategoryAdditionTopBar(
                viewModel = viewModel,
                navController = navController
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(vertical = 24.dp, horizontal = 31.dp)
        ) {
            ExpenditureCategoryAdditionNameTextField(viewModel)
        }
    }
}

@Composable
private fun ExpenditureCategoryAdditionTopBar(
    viewModel: ExpenditureCategoryAdditionViewModel,
    navController: NavController
) {
    val state = viewModel.state()

    CommonTopBar(
        title = "분류 추가",
        navigationIcon = R.drawable.ic_left_arrow,
        onClickNavigation = { navController.popBackStack() },
        action = "완료",
        onClickAction = {
            viewModel.intent(ExpenditureCategoryAdditionEvent.OnClickAddCategory)
        },
        isActionEnabled = state.isCompleteEnable
    )
}

@Composable
private fun ExpenditureCategoryAdditionNameTextField(
    viewModel: ExpenditureCategoryAdditionViewModel
) {
    val state = viewModel.state()

    TextField(
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        value = state.categoryName,
        textStyle = MaterialTheme.typography.paragraphRegular,
        label = { Text(text = "이름") },
        onValueChange = {
            viewModel.intent(ExpenditureCategoryAdditionEvent.OnEnterCategoryName(it))
        })
}