package hw12

import java.io.File
import java.util.*
import kotlin.collections.HashSet

const val FILE_PATH_TRANSLATIONS = "docs/hw12/translations.txt"

fun main() {
    val dictionary = HashSet<Pair<String, String>>()

    File(FILE_PATH_TRANSLATIONS).forEachLine {
        val substrings = it.split(" - ")
        substrings[1].split(',').forEach { word -> dictionary.add(substrings[0] to word) }
    }

    val scanner = Scanner(System.`in`)
    println("Введите слово для перевода: ")
    val word = scanner.nextLine()

    val translations = mutableListOf<String>()

    dictionary.forEach { pair ->
        if (pair.first == word) translations.add(pair.second)
        if (pair.second == word) translations.add(pair.first)
    }

    if (translations.isEmpty()) println("Данного слова нет в словаре")
    else println(translations.joinToString(", "))
}