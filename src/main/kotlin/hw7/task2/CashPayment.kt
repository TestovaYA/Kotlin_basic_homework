package hw7.task2

class CashPayment : Payment() {
    var total: Int? = 0
    var change: Int? = 0

    override fun performPayment() = println("Your cash_payment made.")
}