package hw7

import java.util.*

class Order(customer: Customer, details: OrderDetails, payment: Payment) {
    var date: Date? = null
    var status: OrderStatus? = null

    fun calcPrice() = 1
    fun calcWeight() = 5
    fun pay(payment: Payment) {}
}

class OrderDetails(items: List<OrderItem>) {
    var location: String? = null

    fun calcPrice() = 7
    fun calcWeight() = 6
    fun addItem(item: OrderItem) {}
}

data class OrderItem(
    val name: String,
    val weight: Double,
    val price: Int
)

class Customer {
    private val name: String
    private val address: String?
    private val orders: List<Order> = emptyList()

    constructor(name: String) {
        this.name = name
        address = null
    }

    constructor(name: String, address: String?) {
        this.name = name
        this.address = address
    }

    fun calcPrice() = 5
    fun calcWeight() = 6
    fun addItem(item: OrderItem) {}
}

abstract class Payment() {
    var amount: Int = 0
    var currency: Currency? = null
    var status: PaymentStatus ? = null

    constructor(amount: Int, currency: Currency) : this() {
        this.amount = amount
        this.currency = currency
    }

    open fun performPayment() = println("Your payment made.")
}

class CashPayment : Payment() {
    var total: Int? = 0
    var change: Int? = 0

    override fun performPayment() = println("Your cash_payment made.")
}

class OnlinePayment : Payment() {
    var bankId: String? = null
    var bankName: String? = null

    override fun performPayment() = println("Your online_payment made.")

    fun checkIfSucceed() {
        status = PaymentStatus.PAID
    }
}

class DelayedPayment : Payment() {
    var endDate: Date? = null
    var partAmount: String? = null

    override fun performPayment() = println("Your delayed_payment made.")
    fun performPartialPayment(amount: Int) = println("Your partial_payment($amount) made.")
}

enum class OrderStatus {
    SENT,
    WAITING_FOR_PAYMENT,
    PAID,
    PROCESSED,
    RECEIVED
}

enum class Currency(val code: String) {
    RUB("rub"),
    USD("usd"),
    EUR("eur")
}

enum class PaymentStatus {
    NOT_PAID,
    IN_PROCESSING,
    PAID
}
