package hw6

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите N: ")
    val count = scanner.nextInt()

    println("Перечислите числа через пробел :")
    val numbers = ArrayList<Int>(count)

    for (i in 0 until count) {
        numbers.add(scanner.nextInt())
    }
    numbers.sort()

    println(numbers.joinToString(separator = " "))
}