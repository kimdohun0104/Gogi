package com.deepthought.notification

import com.deepthought.bridge.model.Notification
import com.deepthought.bridge.model.enum.NotificationType
import dohun.kim.kinda.kinda_android.KindaViewModel
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_dsl.buildReducer
import dohun.kim.kinda.kinda_dsl.buildSideEffectHandler
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class NotificationViewModel :
    KindaViewModel<NotificationState, NotificationEvent, NotificationSideEffect>(
        initialState = NotificationState(),
        reducer = buildReducer {
            whenEvent<NotificationEvent.AttemptGetNotifications> {
                dispatch(NotificationSideEffect.GetNotifications)
            }

            whenEvent<NotificationEvent.SetNotifications> {
                next(copy(notifications = it.notifications))
            }

            whenEvent<NotificationEvent.OnClickNotificationItem> {
                val query = it.param.map { "${it.key}=${it.value}" }.joinToString(separator = ",")
                val route = "${it.destination}?$query"
                next(copy(navigate = Event(route)))
            }
        },
        sideEffectHandler = buildSideEffectHandler {
            whenSideEffect<NotificationSideEffect.GetNotifications> {
                NotificationEvent.SetNotifications(
                    listOf(
                        Notification(
                            type = NotificationType.Expenditure,
                            title = "12월 업데이트 사항\n알림, 새로운 기능 등...",
                            date = SimpleDateFormat(
                                "yyyy-MM-dd",
                                Locale.KOREA
                            ).parse("2020-12-10").time,
                            destination = "expenditureDetail",
                            parameters = mapOf("id" to "1")
                        ),
                        Notification(
                            type = NotificationType.ExpenditureAlarm,
                            title = "12월 업데이트 사항\n알림, 새로운 기능 등...",
                            date = SimpleDateFormat(
                                "yyyy-MM-dd",
                                Locale.KOREA
                            ).parse("2020-12-10").time,
                            destination = "expenditureDetail",
                            parameters = mapOf("id" to "1")
                        ),
                        Notification(
                            type = NotificationType.Notice,
                            title = "12월 업데이트 사항\n알림, 새로운 기능 등...",
                            date = SimpleDateFormat(
                                "yyyy-MM-dd",
                                Locale.KOREA
                            ).parse("2020-12-10").time,
                            destination = "expenditureDetail",
                            parameters = mapOf("id" to "1")
                        )
                    )
                )
            }
        }
    ) {
    init {
        intent(NotificationEvent.AttemptGetNotifications)
    }
}