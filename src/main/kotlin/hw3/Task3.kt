package hw3

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите длины сторон треугольника - A, B, C: ")
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()

    if (a <= 0 || b <= 0 || c <= 0) {
        println("Длина стороны треугольника должна быть больше 0")
        return
    }

    if ((a > b + c) && (b > a + c) && (c > a + b)) {
        println("Треугольник с такими сторонами не существует")
        return
    }

    if (isRightTriangle(a, b, c)) println("Прямоугольный")
    if (isAcuteTriangle(a, b, c)) println("Остроугольный")
    if (isObtuseTriangle(a, b, c)) println("Тупоугольный")
}

/**
 * Функция, проверяющая является ли треугольник прямоугольным
 */
fun isRightTriangle(a: Int, b: Int, c: Int): Boolean {
    val max = maxOf(a, b, c)

    return when {
        max == a && (a * a == b * b + c * c) -> true
        max == b && (b * b == a * a + c * c) -> true
        max == c && (c * c == b * b + a * a) -> true
        else -> false
    }
}

/**
 * Функция, проверяющая является ли треугольник остроугольным
 */
fun isAcuteTriangle(a: Int, b: Int, c: Int): Boolean {
    val max = maxOf(a, b, c)

    return when {
        max == a && (a * a < b * b + c * c) -> true
        max == b && (b * b < a * a + c * c) -> true
        max == c && (c * c < b * b + a * a) -> true
        else -> false
    }
}

/**
 * Функция, проверяющая является ли треугольник тупоугольным
 */
fun isObtuseTriangle(a: Int, b: Int, c: Int): Boolean {
    val max = maxOf(a, b, c)

    return when {
        max == a && (a * a > b * b + c * c) -> true
        max == b && (b * b > a * a + c * c) -> true
        max == c && (c * c > b * b + a * a) -> true
        else -> false
    }
}