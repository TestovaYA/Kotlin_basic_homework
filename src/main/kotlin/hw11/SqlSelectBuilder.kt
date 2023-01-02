package hw11

class SqlSelectBuilder {
    private val columns = mutableListOf<String>()
    private lateinit var table: String
    private var whereString: Where? = null

    fun select(vararg columns: String) = this.columns.addAll(columns)

    fun from(table: String) {
        this.table = table
    }

    fun where(block: Where.() -> Unit) {
        whereString = WhereOperator().apply(block)
    }

    override fun toString(): String {
        val selectColumns = if (columns.isEmpty()) "*" else columns.joinToString(", ")

        return "select $selectColumns from $table" + if (whereString == null) "" else " where $whereString"
    }

    fun build() = toString()
}

fun query(init: SqlSelectBuilder.() -> Unit) = SqlSelectBuilder().apply(init)