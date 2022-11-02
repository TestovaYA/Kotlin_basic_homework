package hw5

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите пароль для проверки: ")

    val line = scanner.nextLine()
    println(checkPassword(line))
}

fun checkPassword(line: String): String {
    val answer = StringBuilder()

    if (line.length < 6) answer.appendLine("Длина пароля меньше 6 символов")

    var digits = 0
    var upperCases = 0
    for (char in line) {
        if (char.isDigit()) digits++
        if (char.isUpperCase()) upperCases++
    }
    if (digits < 1) answer.appendLine("Пароль не содержит цифр")
    if (upperCases < 1) answer.appendLine("Пароль не содержит заглавных букв")
    if (isContainThreeChars(line)) answer.appendLine("Пароль содержит 3 идущих подряд одинаковых символа")

    answer.appendLine(if (answer.isEmpty()) "Проверка пароля пройдена" else "Проверка пароля не пройдена")

    return answer.toString()
}

fun isContainThreeChars(line: String): Boolean {
    for (i in 0 until line.length - 2) {
        if (line[i] == line[i + 1] && line[i] == line[i + 2]) return true
    }
    return false
}