package hw6

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите числа через пробел: ")

    val list = scanner.nextLine().split(" ").map { it.toInt() }

    val min = list.minOrNull()
    val max = list.maxOrNull()
    val avg = list.average()

    println("$min $avg $max")
}