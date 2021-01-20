package com.deepthought.ponyo.primitive

import com.deepthought.ponyo.ext.isPositive
import com.deepthought.ponyo.type.Constrained
import com.deepthought.ponyo.withConstraints

class PositiveNumber private constructor(val number: Int) {

    companion object {
        fun of(number: Int): Constrained<PositiveNumber> = withConstraints(PositiveNumber(number)) {
            constrain(PositiveNumber::number to Int::isPositive)
//            constrain(PositiveNumber::number) { it > 0 }
        }
    }
}