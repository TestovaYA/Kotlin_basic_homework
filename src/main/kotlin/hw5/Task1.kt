package hw5

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите 4 целых числа: ")

    val numberA = scanner.nextInt()
    val numberB = scanner.nextInt()
    val numberC = scanner.nextInt()
    val numberD = scanner.nextInt()

    val array = arrayListOf(numberA, numberB, numberC, numberD)
    println(array.minOrNull())
}