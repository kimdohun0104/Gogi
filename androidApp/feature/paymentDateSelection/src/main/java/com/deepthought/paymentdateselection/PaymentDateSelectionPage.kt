package com.deepthought.paymentdateselection

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.deepthought.core.common.CommonTopBar
import com.deepthought.core.theme.colorGray100
import com.deepthought.core.theme.colorGray600

@Composable
fun PaymentDateSelectionPage(
    viewModel: PaymentDateSelectionViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = {
            PaymentDateSelectionTopBar(navController)
        }
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp)
        ) {
            PaymentDateTextField()
            Box(modifier = Modifier.height(6.dp))
            PaymentDateLastDayCheckbox()
        }
    }
}

@Composable
private fun PaymentDateSelectionTopBar(
    navController: NavController
) {
    CommonTopBar(
        title = "지출일 입력",
        navigationIcon = R.drawable.ic_left_arrow,
        onClickNavigation = {
            navController.popBackStack()
        },
        action = "확인",
        onClickAction = {}
    )
}

@Composable
private fun PaymentDateTextField() {
    TextField(
        value = "",
        onValueChange = {

        },
        label = { Text("지출일") },
        trailingIcon = { Text(text = "일") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun PaymentDateLastDayCheckbox() {
    Row {
        Box(modifier = Modifier.weight(1f))
        Text(
            text = "말일",
            style = MaterialTheme.typography.caption,
            color = colorGray600
        )
        Box(modifier = Modifier.width(8.dp))
        RadioButton(
            selected = false,
            onClick = {}
        )
    }
}