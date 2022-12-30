package hw11

class SqlSelectBuilder {
    private val columns = mutableListOf<String>()
    private lateinit var table: String
    private var whereString: String = ""

    fun select(vararg columns: String) = this.columns.addAll(columns)

    fun from(table: String) {
        this.table = table
    }

    fun where(function: () -> Unit) {
        whereString = " where "
        function()
    }

    infix fun String.eq(number: Int) {
        whereString += "$this = $number"
    }

    infix fun String.eq(string: String?) {
        whereString += when (string) {
            null -> "$this is null"
            else -> "$this = '$string'"
        }
    }

    infix fun String.nonEq(number: Int) {
        whereString += "$this != $number"
    }

    infix fun String.nonEq(string: String?) {
        whereString += when (string) {
            null -> "$this !is null"
            else -> "$this != '$string'"
        }
    }

    fun build() = toString()

    override fun toString(): String {
        val selectColumns = if (columns.isEmpty()) "*" else columns.joinToString(", ")

        return "select $selectColumns from $table$whereString"
    }
}

fun query(init: SqlSelectBuilder.() -> Unit) = SqlSelectBuilder().apply(init)