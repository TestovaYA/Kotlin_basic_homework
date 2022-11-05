package hw6

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите числа через пробел: ")

    val list = scanner.nextLine().split(" ").map { it.toInt() }.sorted()

    val min = list.first()
    val max = list.last()
    val avg = list[list.size / 2]  //"среднее" == из середины отсортированного массива

    println("$min $avg $max")
}