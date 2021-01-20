package com.deepthought.ponyo.constraint

data class ViolatedConstraint(
    val propertyName: String,
    val validationName: String? = null
) {
    val message: String
        get() = "Violated at [${propertyName}] for [${validationName ?: "lambda function"}]"
}