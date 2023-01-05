package hw12

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите строку: ")
    val line = scanner.nextLine()

    val chars = mutableMapOf<Char, Int>()

    line.forEach { chars[it] = chars[it]?.plus(1) ?: 1 }

    println(chars)
}