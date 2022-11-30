package hw7.task2

import java.util.*

class Order(
    private val customer: Customer,
    private val details: OrderDetails,
    private val payment: Payment?,
    private val date: Date,
    private val status: OrderStatus,
) {
    constructor(customer: Customer, details: OrderDetails, payment: Payment? = null)
            : this(customer, details, payment, Date(), OrderStatus.WAITING_FOR_PAYMENT)

    fun calcPrice() = 1
    fun calcWeight() = 5
    fun pay(payment: Payment) {}
}