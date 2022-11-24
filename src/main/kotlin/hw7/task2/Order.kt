package hw7.task2

import java.util.*

class Order(customer: Customer, details: OrderDetails, payment: Payment) {
    var customer: Customer? = null
    var details: OrderDetails? = null
    var payment: Payment? = null

    var date: Date? = null
    var status: OrderStatus? = null

    fun calcPrice() = 1
    fun calcWeight() = 5
    fun pay(payment: Payment) {}
}