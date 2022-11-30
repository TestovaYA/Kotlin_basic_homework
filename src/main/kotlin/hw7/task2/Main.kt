package hw7.task2

fun main() {
    val customer = Customer("Вася")
    val listOrderItems = listOf(OrderItem("item", 1.0, 100))
    val orderDetails = OrderDetails(listOrderItems, "location")
    val payment = CashPayment(111, 2, Currency.RUB)
    val order = Order(customer, orderDetails, payment)
    println(order)
}