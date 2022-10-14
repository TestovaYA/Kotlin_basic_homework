package hw2

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите трехзначное число: ")
    val inputNumber = scanner.nextInt()

    if (inputNumber !in 100 .. 999) {
        println("Число не является трехзначным.")
        return
    }

    var temp = inputNumber
    var sum = 0

    while (temp > 0) {
        sum += temp % 10
        temp /= 10
    }

    println("Сумма цифр равна =  $sum")
}