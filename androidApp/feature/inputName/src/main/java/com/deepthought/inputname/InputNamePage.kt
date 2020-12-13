package com.deepthought.inputname

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
import com.deepghought.core.theme.paragraphRegular
import com.deepghought.core.common.CommonTopBar
import androidx.navigation.compose.navigate
import com.deepghought.core.ext.event
import com.deepghought.core.ext.state

@Composable
fun InputNamePage(
    viewModel: InputNameViewModel,
    navController: NavController
) {
    viewModel.event {
        navigateHome.getData()?.let {
            navController.navigate("home")
        }
    }

    Scaffold(
        topBar = { InputNameTopBar(viewModel) },
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            InputNameTextField(viewModel)
        }
    }
}

@Composable
private fun InputNameTopBar(viewModel: InputNameViewModel) {
    val state = viewModel.state()
    CommonTopBar(
        title = "이름 입력",
        isActionEnabled = state.isNextBtnEnabled,
        action = "완료",
        onClickAction = {
            viewModel.intent(InputNameEvent.OnClickInputNameComplete)
        }
    )
}

@Composable
private fun InputNameTextField(viewModel: InputNameViewModel) {
    val state = viewModel.state()
    TextField(
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        value = state.name,
        textStyle = MaterialTheme.typography.paragraphRegular(),
        label = { Text(text = "이름") },
        onValueChange = {
            viewModel.intent(InputNameEvent.OnEnterName(it))
        })
}
