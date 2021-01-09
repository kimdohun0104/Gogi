package com.deepthought.paymentdateselection

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.deepthought.core.common.CommonTopBar
import com.deepthought.core.ext.event
import com.deepthought.core.ext.setToSavedState
import com.deepthought.core.ext.state
import com.deepthought.core.theme.captionRegular
import com.deepthought.core.theme.colorGray100
import com.deepthought.core.theme.colorGray600

@Composable
fun PaymentDateSelectionPage(
    viewModel: PaymentDateSelectionViewModel,
    navController: NavController
) {
    viewModel.event {
        it.popWithDate.getData()?.let { date ->
            navController.setToSavedState("paymentDate", date)
            navController.popBackStack()
        }
    }

    Scaffold(
        topBar = {
            PaymentDateSelectionTopBar(
                viewModel = viewModel,
                navController = navController
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp)
        ) {
            PaymentDateTextField(viewModel = viewModel)
            Box(modifier = Modifier.height(6.dp))
            PaymentDateLastDayCheckbox(viewModel = viewModel)
        }
    }
}

@Composable
private fun PaymentDateSelectionTopBar(
    viewModel: PaymentDateSelectionViewModel,
    navController: NavController
) {
    val state = viewModel.state()

    CommonTopBar(
        title = "지출일 입력",
        navigationIcon = R.drawable.ic_left_arrow,
        onClickNavigation = {
            navController.popBackStack()
        },
        action = "확인",
        isActionEnabled = state.isConfirmEnable,
        onClickAction = {
            viewModel.intent(PaymentDateSelectionEvent.OnClickConfirm)
        }
    )
}

@Composable
private fun PaymentDateTextField(
    viewModel: PaymentDateSelectionViewModel
) {
    val state = viewModel.state()

    TextField(
        value = state.date,
        onValueChange = {
            viewModel.intent(PaymentDateSelectionEvent.OnEnterPaymentDate(it))
        },
        label = { Text("지출일") },
        trailingIcon = { Text(text = "일") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun PaymentDateLastDayCheckbox(
    viewModel: PaymentDateSelectionViewModel
) {
    val state = viewModel.state()

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = state.dateTextFieldErrorText,
            style = MaterialTheme.typography.captionRegular,
            color = MaterialTheme.colors.error,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "말일",
            style = MaterialTheme.typography.caption,
            color = colorGray600
        )
        Box(modifier = Modifier.width(8.dp))
        RadioButton(
            selected = state.isLastDay,
            onClick = {
                viewModel.intent(PaymentDateSelectionEvent.OnClickLastDay)
            }
        )
    }
}