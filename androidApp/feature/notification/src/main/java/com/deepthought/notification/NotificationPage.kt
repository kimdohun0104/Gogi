package com.deepthought.notification

import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.deepthought.core.common.CommonTopBar
import com.deepthought.core.ext.event
import com.deepthought.core.ext.state
import com.deepthought.core.theme.colorGray200
import com.deepthought.notification.component.NotificationListItem

@Composable
fun NotificationPage(
    viewModel: NotificationViewModel,
    navController: NavController
) {
    viewModel.event {
        navigate.getData()?.let { route ->
            navController.navigate(route)
        }
    }

    Scaffold(
        topBar = {
            CommonTopBar(
                title = "알림",
                navigationIcon = R.drawable.ic_close,
                onClickNavigation = { navController.popBackStack() }
            )
        }
    ) {
        NotificationList(viewModel = viewModel)
    }
}

@Composable
fun NotificationList(
    viewModel: NotificationViewModel
) {
    val state = viewModel.state()

    LazyColumnFor(items = state.notifications) {
        NotificationListItem(viewModel = viewModel, notification = it)
        Divider(color = colorGray200, thickness = 1.dp)
    }
}

