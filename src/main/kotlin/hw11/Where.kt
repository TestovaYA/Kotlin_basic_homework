package hw11

abstract class Where {
    fun and(block: Where.() -> Unit) {
        addOperand(WhereOperatorAnd().apply(block))
    }

    fun or(block: Where.() -> Unit) {
        addOperand(WhereOperatorOr().apply(block))
    }

    infix fun String.eq(value: Any?) {
        addOperand(WhereEq(this, value))
    }

    infix fun String.nonEq(value: Any?) {
        addOperand(WhereNonEq(this, value))
    }

    protected abstract fun addOperand(operand: Where)
}