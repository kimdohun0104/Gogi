package com.deepthought.core.ext

import org.mockito.Mockito

fun <T> anyNotNull(): T = Mockito.any<T>()