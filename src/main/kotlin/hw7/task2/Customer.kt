package hw7.task2

class Customer(
    private val name: String,
    private val address: String? = null,
    private val orders: List<Order> = emptyList()
) {

    fun calcPrice() = 5
    fun calcWeight() = 6
    fun addItem(item: OrderItem) {}
}
