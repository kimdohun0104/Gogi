package com.deepthought.ponyo

import com.deepthought.ponyo.constraint.ConstraintsBuilder
import com.deepthought.ponyo.type.Constrained

inline fun <reified T> withConstraints(
    obj: T,
    constraintsBuilder: ConstraintsBuilder<T>.() -> Unit
): Constrained<T> {
    return ConstraintsBuilder(obj).apply(constraintsBuilder).getConstrained<T>()
}