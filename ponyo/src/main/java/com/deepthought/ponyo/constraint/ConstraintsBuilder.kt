package com.deepthought.ponyo.constraint

import com.deepthought.ponyo.type.Constrained
import kotlin.reflect.KProperty1
import kotlin.reflect.KFunction1

class ConstraintsBuilder<T>(
    val obj: T
) {

    val violatedConstraints = mutableSetOf<ViolatedConstraint>()

    fun <P> constrain(constraint: Pair<KProperty1<T, P>, KFunction1<P, Boolean>>) {
        val property = constraint.first
        val propertyValue = property.get(obj)
        val validation: KFunction1<P, Boolean> = constraint.second

        if (!validation(propertyValue)) {
            val violatedConstraint = ViolatedConstraint(
                propertyName = property.name,
                validationName = validation.name
            )
            violatedConstraints.add(violatedConstraint)
        }
    }

    fun <P> constrain(property: KProperty1<T, P>, validation: (P) -> Boolean) {
        if (!validation(property.get(obj))) {
            val violatedConstraint = ViolatedConstraint(
                propertyName = property.name
            )
            violatedConstraints.add(violatedConstraint)
        }
    }

    inline fun <reified TYPE : T> getConstrained(): Constrained<T> =
        if (violatedConstraints.isNullOrEmpty()) {
            Constrained.Valid(obj)
        } else {
            val typeName = TYPE::class.simpleName
            Constrained.Invalid(
                violatedConstraints,
                generateViolationMessage(typeName ?: "")
            )
        }

    fun generateViolationMessage(typeName: String): String {
        val size = violatedConstraints.size
        val indexedViolations: String =
            violatedConstraints.foldIndexed("") { index, acc, violatedConstraint ->
                val isLastViolation = size == index + 1
                val nextLine = if (isLastViolation) "" else "\n"
                acc + "${index + 1}. ${violatedConstraint.message}$nextLine"
            }

        return """
            $size violation founded at $typeName 
            [
                $indexedViolations
            ]
        """.trimIndent()
    }
}