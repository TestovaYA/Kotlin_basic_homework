package hw2

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите ширину и высоту прямоугольника: ")
    val width = scanner.nextInt()
    val height = scanner.nextInt()

    if (width <= 0 || height <= 0) {
        println("Длина стороны прямоуголника не может быть отрицательным числом")
        return
    }

    println("Квадрат диагонали прямоугольника = ${width * width + height * height}")
}