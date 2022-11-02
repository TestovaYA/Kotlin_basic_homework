package hw4

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите целое неотрицательное число: ")

    val number = scanner.nextInt()
    if (number <= 0) {
        println("Ошибка. Число не является неотрицательным")
        return
    }
    printTriangle(number)
}

fun printTriangle(number: Int) {
    var step = 1
    while (step <= number) {
        print(" ".repeat(number-step))
        println("* ".repeat(step).trim())
        step++
    }
}