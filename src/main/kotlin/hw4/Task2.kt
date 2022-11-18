package hw4

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите число: ")

    val number = scanner.nextLong()
    println(findFactorial(number))
}

tailrec fun findFactorial(number: Long, run: Long = 1): Long {
    val temp = run * number
    return if (number <= 1) {
        temp
    } else {
        findFactorial(number - 1, temp)
    }
}