package hw7.task2

import java.util.*

class DelayedPayment : Payment() {
    var endDate: Date? = null
    var partAmount: String? = null

    override fun performPayment() = println("Your delayed_payment made.")
    fun performPartialPayment(amount: Int) = println("Your partial_payment($amount) made.")
}