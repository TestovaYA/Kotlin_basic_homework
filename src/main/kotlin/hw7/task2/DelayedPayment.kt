package hw7.task2

import java.util.*

class DelayedPayment(
    private val endDate: Date,
    private val partAmount: String,
    override val amount: Int,
    override val currency: Currency
) : Payment(amount, currency, PaymentStatus.NOT_PAID) {

    override fun performPayment() = println("Your delayed_payment made.")
    fun performPartialPayment(amount: Int) = println("Your partial_payment($amount) made.")
}