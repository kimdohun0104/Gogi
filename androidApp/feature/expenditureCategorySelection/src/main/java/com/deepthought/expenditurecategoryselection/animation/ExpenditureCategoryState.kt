package com.deepthought.expenditurecategoryselection.animation

import androidx.compose.animation.DpPropKey
import androidx.compose.animation.core.FloatPropKey
import androidx.compose.animation.core.IntPropKey
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.dp
import com.deepthought.expenditurecategoryselection.animation.ExpenditureCategoryState.SELECTION
import com.deepthought.expenditurecategoryselection.animation.ExpenditureCategoryState.ADDITION

val deleteButtonSize = DpPropKey()
val deleteButtonStartSize = DpPropKey()
val editButtonOpacity = FloatPropKey()

enum class ExpenditureCategoryState {
    ADDITION, SELECTION
}

val expenditureCategoryDefinition = transitionDefinition<ExpenditureCategoryState> {

    state(SELECTION) {
        this[deleteButtonSize] = 0.dp
        this[deleteButtonStartSize] = 0.dp
        this[editButtonOpacity] = 0f
    }

    state(ADDITION) {
        this[deleteButtonSize] = 10.dp
        this[deleteButtonStartSize] = 18.dp
        this[editButtonOpacity] = 1f
    }

    transition(fromState = SELECTION, toState = ADDITION) {
        deleteButtonSize using tween(500)
        deleteButtonStartSize using tween (500)
        editButtonOpacity using tween(500)
    }
}