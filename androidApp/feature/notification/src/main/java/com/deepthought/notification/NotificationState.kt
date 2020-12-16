package com.deepthought.notification

import com.deepthought.bridge.model.Notification
import dohun.kim.kinda.kinda_core.Event
import dohun.kim.kinda.kinda_core.KindaEvent
import dohun.kim.kinda.kinda_core.KindaSideEffect
import dohun.kim.kinda.kinda_core.KindaState

data class NotificationState(
    val notifications: List<Notification> = emptyList(),

    val navigate: Event<String> = Event()
) : KindaState

sealed class NotificationEvent : KindaEvent {
    object AttemptGetNotifications : NotificationEvent()

    data class SetNotifications(val notifications: List<Notification>) : NotificationEvent()

    data class OnClickNotificationItem(
        val destination: String,
        val param: Map<String, String>
    ) : NotificationEvent()
}

sealed class NotificationSideEffect : KindaSideEffect {
    object GetNotifications : NotificationSideEffect()
}
