package hw7.task2

class OnlinePayment : Payment() {
    var bankId: String? = null
    var bankName: String? = null

    override fun performPayment() = println("Your online_payment made.")

    fun checkIfSucceed() {
        status = PaymentStatus.PAID
    }
}