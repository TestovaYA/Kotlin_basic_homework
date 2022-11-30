package hw7.task2

abstract class Payment(
    open val amount: Int,
    open val currency: Currency,
    open val status: PaymentStatus
) {
    abstract fun performPayment(): Unit
}