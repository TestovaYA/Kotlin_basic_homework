package hw2

import java.util.Scanner
//месяц = 30 дней, год = 360 дней
fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите количество минут: ")
    val minutes = scanner.nextInt()

    if (minutes < 60 * 24 * 30) {
        println("0 месяцев")
        return
    }

    val years = minutes / 60 / 24 / 360
    val months = (minutes - years * 360 * 24 * 60) / 60 / 24 / 30

    println("${generateYearsPostfix(years)} ${generateMonthsPostfix(months)}")
}

fun generateYearsPostfix(years: Int): String {
    if (years == 0) return ""

    return when (years.toString().last().digitToInt()) {
        1 -> "$years год"
        in 2..4 -> "$years года"
        else -> "$years лет"
    }
}

fun generateMonthsPostfix(months: Int): String {
    if (months == 0) return ""

    return when (months.toString().last().digitToInt()) {
        1 -> "$months месяц"
        in 2..4 -> "$months месяца"
        else -> "$months месяцев"
    }
}