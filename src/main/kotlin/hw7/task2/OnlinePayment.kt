package hw7.task2

class OnlinePayment(
    private val bankId: String,
    private val bankName: String,
    override val amount: Int
) : Payment(amount, Currency.RUB, PaymentStatus.NOT_PAID) {

    override fun performPayment() = println("Your online_payment made.")
    fun checkIfSucceed(): PaymentStatus = PaymentStatus.PAID
}