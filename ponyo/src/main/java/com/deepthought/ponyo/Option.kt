package com.deepthought.ponyo

import java.util.*

sealed class Option<T> {

    data class Some<T>(val data: T) : Option<T>()

    object None : Option<Unit>()
}