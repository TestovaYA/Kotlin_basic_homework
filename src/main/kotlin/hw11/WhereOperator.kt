package hw11

open class WhereOperator : Where() {
    open val operator = ""

    private val whereOperands = mutableListOf<Where>()

    override fun addOperand(operand: Where) {
        whereOperands += operand
    }

    override fun toString() =
        if (whereOperands.size == 1) whereOperands[0].toString()
        else "(" + whereOperands.joinToString(separator = " $operator ") + ")"

}