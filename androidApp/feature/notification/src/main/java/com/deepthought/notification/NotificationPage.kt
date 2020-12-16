package com.deepthought.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.deepghought.core.common.CommonTopBar
import com.deepghought.core.ext.event
import com.deepghought.core.ext.state
import com.deepghought.core.theme.colorGray200
import com.deepghought.core.theme.colorGray500
import com.deepthought.bridge.model.Notification
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
fun NotificationList(viewModel: NotificationViewModel) {
    val state = viewModel.state()

    LazyColumnFor(items = state.notifications) {
        NotificationListItem(notification = it)
        Divider(color = colorGray200, thickness = 1.dp)
    }
}

