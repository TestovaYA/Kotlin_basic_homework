import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите число в диапазоне от 1 до 99: ")
    val inputNumber = scanner.nextInt()
    if (inputNumber !in 1..99) {
        println("Вы ввели неверное число")
        return
    }

    var tempNumber = inputNumber

    val xc = tempNumber / 90
    tempNumber -= 90 * xc
    if (xc > 0) print("XC")

    val l = tempNumber / 50
    tempNumber -= 50 * l
    if (l > 0) print("L")

    val xl = tempNumber / 40
    tempNumber -= 40 * xl
    if (xl > 0) print("XL")

    var x = tempNumber / 10
    tempNumber -= 10 * x
    while (x > 0) {
        print("X")
        x--
    }

    var ix = tempNumber / 9
    tempNumber -= 9 * ix
    while (ix > 0) {
        print("IX")
        ix--
    }

    val v = tempNumber / 5
    tempNumber -= 5 * v
    if (v > 0) print("V")

    val iv = tempNumber / 4
    tempNumber -= 4 * iv
    if (iv > 0) print("IV")

    while (tempNumber > 0) {
        print("I")
        tempNumber--
    }
}