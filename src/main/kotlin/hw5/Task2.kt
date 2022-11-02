package hw5

import java.util.*
import kotlin.math.pow

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите 4 целых числа от -10000 до 10000 ")

    val numberA = scanner.nextInt()
    val numberB = scanner.nextInt()
    val numberC = scanner.nextInt()
    val numberD = scanner.nextInt()

    val range = -10000..10000

    if (numberA !in range || numberB !in range || numberC !in range || numberD !in range) {
        println("Ошибка. Числа не входят в заданный диапазон")
        return
    }

    println(calculateLength(numberA, numberB, numberC, numberD))
}

fun calculateLength(x1: Int, y1: Int, x2: Int, y2: Int) =
    ((x2 - x1).toDouble().pow(2) + (y2 - y1).toDouble().pow(2)).pow(0.5)