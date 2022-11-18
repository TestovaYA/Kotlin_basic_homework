package hw4

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите целое неотрицательное число: ")

    val number = scanner.nextInt()
    if (number <= 0) {
        println("Ошибка. Число не является неотрицательным")
        return
    }

    println(isPalindrome(number))
}

fun isPalindrome(number: Int): Boolean {
    return number.toString() == number.toString().reversed()
}