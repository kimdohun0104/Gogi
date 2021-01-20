package com.deepthought.ponyo

import com.deepthought.ponyo.primitive.PositiveNumber
import com.deepthought.ponyo.type.Constrained
import org.junit.Assert.assertTrue
import org.junit.Test

class PositiveNumberTest {

    @Test
    fun `when value is negative`() {
        val positiveNumber = PositiveNumber.of(-1)
        assertTrue(positiveNumber is Constrained.Invalid)
        println((positiveNumber as? Constrained.Invalid)?.message)
    }

    @Test
    fun `when value is positive`() {
        val positiveNumber = PositiveNumber.of(1)
        assertTrue(positiveNumber is Constrained.Valid)
    }
}