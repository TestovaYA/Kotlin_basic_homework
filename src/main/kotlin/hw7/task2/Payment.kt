package hw7.task2

import java.util.Currency

abstract class Payment() {
    var amount: Int = 0
    var currency: Currency? = null
    var status: PaymentStatus? = null

    constructor(amount: Int, currency: Currency) : this() {
        this.amount = amount
        this.currency = currency
    }

    open fun performPayment() = println("Your payment made.")
}