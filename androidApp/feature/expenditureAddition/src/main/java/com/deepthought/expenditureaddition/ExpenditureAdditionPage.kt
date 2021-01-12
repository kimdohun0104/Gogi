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
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.bridge.model.PaymentDate
import com.deepthought.core.common.CommonTopBar
import com.deepthought.core.ext.*
import com.deepthought.core.theme.captionRegular
import com.deepthought.core.theme.colorGray500
import com.deepthought.core.theme.paragraph
import com.deepthought.core.theme.paragraphRegular

@Composable
fun ExpenditureAdditionPage(
    viewModel: ExpenditureAdditionViewModel,
    navController: NavController
) {
    viewModel.event {
        it.popBackStack.getData()?.let {
            navController.navigateBackTo("home")
        }
    }

    navController.observeFromSavedState<ExpenditureCategory>(
        key = "expenditureCategory",
        callback = {
            viewModel.intent(ExpenditureAdditionEvent.OnSelectExpenditureCategory(it))
        })

    navController.observeFromSavedState<PaymentDate>(
        key = "paymentDate",
        callback = {
            viewModel.intent(ExpenditureAdditionEvent.OnSelectPaymentDate(it))
        })

    Scaffold(
        topBar = {
            ExpenditureAdditionTopBar(viewModel = viewModel, navController = navController)
        }
    ) {
        Column(
            modifier = Modifier.padding(vertical = 24.dp, horizontal = 32.dp)
        ) {

            ExpenditureAdditionNameTextField(viewModel)
            Box(modifier = Modifier.height(24.dp))
            ExpenditureAdditionPriceTextField(viewModel)
            Box(modifier = Modifier.height(24.dp))
            ExpenditureAdditionSelectPaymentDay(
                viewModel = viewModel,
                navController = navController
            )
            Box(modifier = Modifier.height(24.dp))
            ExpenditureAdditionSelectCategory(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}

@Composable
private fun ExpenditureAdditionTopBar(
    viewModel: ExpenditureAdditionViewModel,
    navController: NavController
) {
    val state = viewModel.state()

    CommonTopBar(
        title = "지출 추가",
        navigationIcon = R.drawable.ic_close,
        onClickNavigation = { navController.popBackStack() },
        action = "확인",
        isActionEnabled = state.isConfirmEnabled,
        onClickAction = {
            viewModel.intent(ExpenditureAdditionEvent.AttemptInsertExpenditure)
        }
    )
}

@Composable
private fun ExpenditureAdditionNameTextField(
    viewModel: ExpenditureAdditionViewModel
) {
    val state = viewModel.state()

    TextField(
        value = state.name,
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.paragraphRegular,
        label = { Text(text = "이름") },
        onValueChange = {
            viewModel.intent(ExpenditureAdditionEvent.OnEnterName(it))
        })
}

@Composable
private fun ExpenditureAdditionPriceTextField(
    viewModel: ExpenditureAdditionViewModel
) {
    val state = viewModel.state()

    TextField(
        value = state.price,
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.paragraphRegular,
        label = { Text(text = "금액") },
        onValueChange = {
            viewModel.intent(ExpenditureAdditionEvent.OnEnterPrice(it))
        })
}

@Composable
private fun ExpenditureAdditionSelectPaymentDay(
    viewModel: ExpenditureAdditionViewModel,
    navController: NavController
) {
    val state = viewModel.state()

    Text(
        "지출일",
        style = MaterialTheme.typography.captionRegular
            .copy(color = colorGray500)
    )
    Row {
        Text(
            text = state.paymentDate?.toString() ?: "",
            style = MaterialTheme.typography.paragraphRegular,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "선택",
            style = MaterialTheme.typography.paragraph
                .copy(color = MaterialTheme.colors.primary),
            modifier = Modifier.clickable(onClick = {
                navController.navigate("paymentDateSelection")
            })
        )
    }
}

@Composable
private fun ExpenditureAdditionSelectCategory(
    viewModel: ExpenditureAdditionViewModel,
    navController: NavController
) {
    val state = viewModel.state()

    Text(
        "분류",
        style = MaterialTheme.typography.captionRegular
            .copy(color = colorGray500)
    )
    Row {
        Text(
            text = state.expenditureCategory?.name ?: "",
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