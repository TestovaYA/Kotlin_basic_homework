package hw7.task2

class CashPayment(
    private val total: Int,
    override val amount: Int,
    override val currency: Currency
) : Payment(amount, Currency.RUB, PaymentStatus.NOT_PAID) {

    val change: Int
        get() = 10

    override fun performPayment() = println("Your cash_payment made.")
}