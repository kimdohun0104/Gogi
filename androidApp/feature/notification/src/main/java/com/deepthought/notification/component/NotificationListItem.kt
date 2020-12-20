package com.deepthought.notification.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.deepghought.core.ext.toDefaultDateFormat
import com.deepghought.core.theme.captionRegular
import com.deepghought.core.theme.colorBlueGray400
import com.deepghought.core.theme.colorGray500
import com.deepthought.bridge.model.Notification
import com.deepthought.bridge.model.enum.NotificationType
import com.deepthought.notification.NotificationEvent
import com.deepthought.notification.NotificationViewModel
import com.deepthought.notification.R

@Composable
fun NotificationListItem(
    viewModel: NotificationViewModel,
    notification: Notification
) {
    ConstraintLayout(
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 18.dp)
            .fillMaxWidth()
            .clickable(onClick = {
                viewModel.intent(
                    NotificationEvent.OnClickNotificationItem(
                        notification.destination,
                        notification.parameters
                    )
                )
            })
    ) {
        val (iconBackgroundRef, iconRef, titleRef, dateRef, detailRef) = createRefs()

        NotificationListItemIconBackground(
            iconBackgroundRef = iconBackgroundRef
        )
        NotificationListItemIcon(
            notificationType = notification.type,
            iconRef = iconRef,
            iconBackgroundRef = iconBackgroundRef
        )
        NotificationListItemTitle(
            title = notification.title,
            titleRef = titleRef,
            iconBackgroundRef = iconBackgroundRef,
            detailRef = detailRef
        )
        NotificationListItemDate(
            date = notification.date,
            notificationType = notification.type,
            dateRef = dateRef,
            titleRef = titleRef
        )
        NotificationListItemDetail(
            detailRef = detailRef
        )
    }
}

@Composable
fun ConstraintLayoutScope.NotificationListItemIconBackground(
    iconBackgroundRef: ConstrainedLayoutReference
) {
    Box(
        modifier = Modifier.constrainAs(iconBackgroundRef) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        }.preferredSize(32.dp)
            .clip(CircleShape)
            .background(colorGray500)
    )
}

@Composable
fun ConstraintLayoutScope.NotificationListItemIcon(
    notificationType: NotificationType,
    iconRef: ConstrainedLayoutReference,
    iconBackgroundRef: ConstrainedLayoutReference
) {
    val iconRes = when (notificationType) {
        is NotificationType.Expenditure -> R.drawable.ic_expenditure
        is NotificationType.ExpenditureAlarm -> R.drawable.ic_alarm
        is NotificationType.Notice -> R.drawable.ic_notice
    }

    Icon(
        vectorResource(iconRes),
        modifier = Modifier.constrainAs(iconRef) {
            centerTo(iconBackgroundRef)
        }
    )
}

@Composable
fun ConstraintLayoutScope.NotificationListItemTitle(
    title: String,
    titleRef: ConstrainedLayoutReference,
    iconBackgroundRef: ConstrainedLayoutReference,
    detailRef: ConstrainedLayoutReference
) {
    Text(
        title,
        Modifier.constrainAs(titleRef) {
            start.linkTo(iconBackgroundRef.end)
            top.linkTo(iconBackgroundRef.top)
            end.linkTo(detailRef.start)

            width = Dimension.fillToConstraints
        }.padding(start = 10.dp),
        style = MaterialTheme.typography.caption
    )
}

@Composable
fun ConstraintLayoutScope.NotificationListItemDate(
    date: Long,
    notificationType: NotificationType,
    dateRef: ConstrainedLayoutReference,
    titleRef: ConstrainedLayoutReference
) {
    val dateText = date.toDefaultDateFormat()
    Text(
        text = "${notificationType.typeText} · $dateText",
        style = MaterialTheme.typography.captionRegular.copy(color = colorBlueGray400),
        modifier = Modifier.constrainAs(dateRef) {
            start.linkTo(titleRef.start)
            top.linkTo(titleRef.bottom)
        }.padding(top = 8.dp, start = 10.dp)
    )
}

@Composable
fun ConstraintLayoutScope.NotificationListItemDetail(
    detailRef: ConstrainedLayoutReference
) {
    Icon(
        asset = vectorResource(id = R.drawable.ic_right_arrow),
        modifier = Modifier.constrainAs(detailRef) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }.padding(end = 24.dp)
    )
}