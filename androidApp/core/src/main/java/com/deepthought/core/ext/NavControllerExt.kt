package com.deepthought.core.ext

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
import java.io.Serializable

fun <T : Serializable> NavController.getFromSavedState(key: String): T? {
    return currentBackStackEntry?.savedStateHandle?.get<T>(key)
}

@Composable
fun <T : Serializable> NavController.observeFromSavedState(
    key: String,
    callback: (T) -> Unit
) {
    val state = currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)?.observeAsState()
    state?.value?.let {
        callback(it)
    }
}

fun <T : Serializable> NavController.setToSavedState(key: String, value: T) {
    previousBackStackEntry?.savedStateHandle?.set(key, value)
}

fun NavController.navigateBackTo(destination: String) {
    navigate(destination) {
        popUpTo(destination) {}
    }
}