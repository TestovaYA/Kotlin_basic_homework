package hw11

class SqlSelectBuilder {
    private val columns = mutableListOf<String>()
    private lateinit var table: String

    fun select(vararg columns: String) = this.columns.addAll(columns)

    fun from(table: String) {
        this.table = table
    }

    fun build() = toString()

    override fun toString(): String {
        val selectColumns = if (columns.isEmpty()) "*" else columns.joinToString(", ")
        return "select $selectColumns from $table"
    }
}

fun query(init: SqlSelectBuilder.() -> Unit) = SqlSelectBuilder().apply(init)