package hw3

import java.time.Month
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите номер месяца и день: ")
    val monthNumber = scanner.nextInt()
    val dayNumber = scanner.nextInt()

    if (monthNumber !in 1..12) {
        println("Номер месяца должен быть в диапазоне от 1 до 12")
        return
    }

    if (dayNumber !in 1..Month.of(monthNumber).length(false)) {
        println("Введеное число не входит в допустимые значения дня заданного месяца")
        return
    }

    println("Дней до Нового года: ${365 - Month.of(monthNumber).firstDayOfYear(false) - 1 + dayNumber}")
}