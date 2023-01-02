package hw11

class WhereEq(val column: String, val value: Any?) : Where() {
    override fun addOperand(operand: Where) {}

    override fun toString(): String {
        return when (value) {
            null -> "$column is null"
            is String -> "$column = '$value'"
            else -> "$column = $value"
        }
    }
}