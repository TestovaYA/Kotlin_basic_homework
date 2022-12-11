package hw7.task2

class OrderDetails(
    private val items: List<OrderItem>,
    private val location: String
) {

    fun calcPrice() = 7
    fun calcWeight() = 6
    fun addItem(item: OrderItem) {}
}