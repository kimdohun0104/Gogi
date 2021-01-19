package com.deepthought.bridge.model

import com.deepthought.bridge.model.enum.NotificationType

data class Notification(

    val type: NotificationType,

    val date: Long,

    val title: String,

    val destination: String,

    val parameters: Map<String, String>
)