package com.deepthought.ponyo.type

import com.deepthought.ponyo.constraint.ViolatedConstraint

sealed class Constrained<T> {

    data class Valid<T>(
        val value: T
    ) : Constrained<T>()

    data class Invalid<T>(
        val violatedConstraints: Set<ViolatedConstraint>,
        val message: String
    ) : Constrained<T>()
}