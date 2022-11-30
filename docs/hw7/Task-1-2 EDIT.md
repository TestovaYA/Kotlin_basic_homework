### ДЗ-7 | Задача 1-2 ###

Придумайте реализацию и опишите свойства и методы класса для двух ситуаций:

1. Необходимо описать класс, описываемый дробные числа (например, 1/2, 3/5). Также реализовать методы сложения и вычитания объектов.

2. Необходимо перенести предложенное текстовое описание структуры класса в код, сохраняя все требовании и назавние полей или методов. Методы можно не реализовывать, достаточно сделать их компилируемыми.

## Описание структуры для второй части

### Заказ

Класс Order, описывающий заказ на покупку в магазине.

Должен содержать поля с данными:
- дата оформления (date: Date)
- текущий статус (status: OrderStatus), где OrderStatus - enum из: отправлен, ждет оплаты, оплачен, обрабатывается, получен
- покупатель (customer: Customer)
- детали заказа (details: OrderDetails)
- опциональная оплата (payment: Payment?)

Также должен содержать методы и конструкторы:
- конструктор, в который передаются объекты Customer, OrderDetails, опциональная оплата Payment?
- calcPrice(): Int
- calcWeight(): Int
- pay(payment: Payment): Unit

### Детали заказа
Класс OrderDetails, описывающий детали заказа

Должен содержать поля с данными:
- локация в виде строки (location: String)
- список товаров (items: List\<OrderItem>)

Также должен содержать методы и конструкторы:
- конструктор, в который передается список товаров List\<OrderItem>
- calcPrice(): Int
- calcWeight(): Int
- addItem(item: OrderItem): Unit
### Товар
Data Класс OrderItem, описывающий каждый товар по отдельности

Должен содержать поля с данными:
- название (name: String)
- вес (weight: Double)
- цена (price: Int)

Также должен содержать методы и конструкторы:
- конструктор, в который передаются цена, вес и название товара

### Покупатель
Класс Customer, описывающий детали заказа

Должен содержать поля с данными:
- имя (name: String)
- опциональный адрес в виде строки (address: String?)
- список заказов (orders: List\<Order>)

Также должен содержать методы и конструкторы:
- конструктор, в который передается имя
- конструктор, в который передается имя и адрес (не обязательно создвавать как отдельный конструктор)
- calcPrice(): Int
- calcWeight(): Int
- addItem(item: OrderItem): Unit
### Оплата
Класс Payment, описывающий способ оплаты и её состояние.
Такой класс можно сделать абстрактным

Должен содержать поля с данными:
- кол-во (amount: Int)
- тип валюты (currency: Currency), где Currency - enum как минимум из: рубли, доллары, евро. такой enum должен содержать в качестве значения текстовый код валюты, например, для рублей - это "rub"
- статус платежа (status: PaymentStatus), где PaymentStatus - enum из: не оплачен, в обработке, оплачен

Также должен содержать методы и конструкторы:
- конструктор, в который передается кол-во и тип валюты
- performPayment(): Unit
#### Оплата наличными

Класс CashPayment, который должен наследоваться от Payment и обаладать доп полем:
- необходимое кол-во для оплаты (amount: Int)
- кол-во, которое было передано (total: Int)
- сдача, если нет, то 0 (change: Int)

Также должен быть перезаписан метод `performPayment()`

#### Оплата онлайн

Класс OnlinePayment, который должен наследоваться от Payment и обаладать доп полями и функциями:
- bankId: String
- bankName: String
- checkIfSucceed(): PaymentStatus

Также должен быть перезаписан метод `performPayment()`

#### Отложенная оплата

Класс DelayedPayment, который должен наследоваться от Payment и обаладать доп полями и функциями:
- endDate: Date
- partAmount: String
- performPartialPayment(amount: Int): Unit

Также должен быть перезаписан метод `performPayment()`
