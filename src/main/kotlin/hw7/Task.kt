package hw7

class Fractian(
    var numenator: Int,
    var denumenator: Int
) {
    fun plus(other: Fractian): Fractian {
        return if (this.denumenator == other.denumenator) {
            Fractian(this.numenator + other.numenator, denumenator)
        } else {
            val nok = findNOK(this.denumenator, other.denumenator)
            val newNumenator1 = this.numenator * nok / this.denumenator
            val newNumenator2 = other.numenator * nok / other.denumenator
            Fractian(newNumenator1 + newNumenator2, nok)
        }
    }

    fun minus(other: Fractian): Fractian {
        return if (this.denumenator == other.denumenator) {
            Fractian(this.numenator - other.numenator, denumenator)
        } else {
            val nok = findNOK(this.denumenator, other.denumenator)
            val newNumenator1 = this.numenator * nok / this.denumenator
            val newNumenator2 = other.numenator * nok / other.denumenator
            Fractian(newNumenator1 - newNumenator2, nok)
        }
    }

    //сокращение дроби
    fun reduce(): Fractian {
        val nod = findNOD(this.numenator, this.denumenator)
        this.numenator = this.numenator / nod
        this.denumenator = this.denumenator / nod
        return this
    }

    //вычисление НОД
    private fun findNOD(first: Int, second: Int): Int {
        var a = first
        var b = second
        while (b != 0) {
            val tmp = a % b
            a = b
            b = tmp
        }
        return a
    }

    //вычисление НОК
    private fun findNOK(first: Int, second: Int): Int {
        return first * second / findNOD(first, second)
    }

    override fun toString(): String {
        return "$numenator/$denumenator"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Fractian

        if (numenator != other.numenator) return false
        if (denumenator != other.denumenator) return false

        return true
    }

    override fun hashCode(): Int {
        var result = numenator
        result = 31 * result + denumenator
        return result
    }

    /* операторы

    // "+" для обыкновенных дробей
    operator fun plus(other: Fractian): Fractian {
        return if (this.denumenator == other.denumenator) {
            Fractian(this.numenator + other.numenator, denumenator)
        } else {
            val nok = findNOK(this.denumenator, other.denumenator)
            val newNumenator1 = this.numenator * nok / this.denumenator
            val newNumenator2 = other.numenator * nok / other.denumenator
            Fractian(newNumenator1 + newNumenator2, nok)
        }
    }

    // "-" для обыкновенных дробей
    operator fun minus(other: Fractian): Fractian {
        return if (this.denumenator == other.denumenator) {
            Fractian(this.numenator - other.numenator, denumenator)
        } else {
            val nok = findNOK(this.denumenator, other.denumenator)
            val newNumenator1 = this.numenator * nok / this.denumenator
            val newNumenator2 = other.numenator * nok / other.denumenator
            Fractian(newNumenator1 - newNumenator2, nok)
        }
    }

    // "*" для обыкновенных дробей
    operator fun times(other: Fractian) =
        Fractian(this.numenator * other.numenator, this.denumenator * other.denumenator)

    // "/" для обыкновенных дробей
    operator fun div(other: Fractian) = Fractian(this.numenator * other.denumenator, this.denumenator * other.numenator)
     */
}

fun main() {
    val first = Fractian(1, 2)
    val second = Fractian(1, 3)

    println("$first + $second = ${first.plus(second)}")
    println("$first - $second = ${first.minus(second)}")

    val third = Fractian(4, 6)
    println("$third = ${third.reduce()}")
}