package hw6

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите первую строку:")
    val line1 = scanner.nextLine().toList()

    println("Введите вторую строку:")
    val line2 = scanner.nextLine().toList()

    println("Выберите действие над строками: \n1 - склеить \n2 - вычесть \n3 - пересечь \nВсе остальные команды приведут к завершению программы.")
    when (scanner.nextLine()) {
        "1" -> {
            println("Результат \"склеивания\" строк:")
            println(line1.plus(line2).joinToString(separator = ""))
        }

        "2" -> {
            println("Результат \"вычитания\" строк:")
            println(line1.minus(line2).joinToString(separator = ""))
        }

        "3" -> {
            println("Результат \"пересечения\" строк:")
            println(line1.intersect(line2).joinToString(separator = ""))
        }
    }
}