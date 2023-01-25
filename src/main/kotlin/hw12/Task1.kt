package hw12

import java.io.File
import java.util.*

const val FILE_PATH = "docs/hw12/files.txt"

val filesWithOperations = mutableMapOf<String, List<String>>()

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите имя файла: ")
    val fileName = scanner.nextLine()

    fillFilesWithOperations()

    if (!filesWithOperations.contains(fileName)) {
        println("Файл с таким названием не найден.")
        return
    }

    println("Введите название операции: ")
    val operation = scanner.nextLine()

    if (filesWithOperations.getValue(fileName).contains(operation)) println("Для файла $fileName операция $operation доступна")
    else println("У пользователя нет доступа для совершения операции $operation")

}

fun fillFilesWithOperations(): MutableMap<String, List<String>> {
    File(FILE_PATH).forEachLine {
        if (it.contains(" - ")) {
            val substrings = it.split(" - ")
            val filename = substrings[0]
            val permissions = substrings[1].split(",")

            filesWithOperations[filename] = permissions
        } else {
            filesWithOperations[it] = emptyList()
        }
    }

    return filesWithOperations
}