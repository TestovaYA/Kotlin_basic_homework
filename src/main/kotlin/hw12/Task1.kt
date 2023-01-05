package hw12

import java.io.File
import java.util.*

fun main() {
    val listOfFiles = mutableMapOf<String, List<String>>()
    val FILE_PATH = "docs/hw12/files.txt"

    File(FILE_PATH).forEachLine {
        if (it.contains(" - ")) {
            val substrings = it.split(" - ")
            val key = substrings[0]
            val values = substrings[1].split(",")

            listOfFiles[key] = values
        } else {
            listOfFiles[it] = emptyList()
        }
    }

    val scanner = Scanner(System.`in`)
    println("Введите имя файла: ")
    val fileName = scanner.nextLine()

    if (!listOfFiles.contains(fileName)) {
        println("Файл с таким названием не найден.")
        return
    }

    println("Введите название операции: ")
    val operation = scanner.nextLine()

    if (listOfFiles.getValue(fileName).contains(operation)) println("Для файла $fileName операция $operation доступна")
    else println("У пользователя нет доступа для совершения операции $operation")

}