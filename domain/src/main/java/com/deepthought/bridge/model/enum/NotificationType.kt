package com.deepthought.bridge.model.enum

sealed class NotificationType(val typeText: String) {

    object Expenditure : NotificationType("지출")
    object ExpenditureAlarm : NotificationType("지출 알람")
    object Notice : NotificationType("공지사항")
}