### ДЗ-2 | Задача 2 ###


**На вход подается** одно натуральное число ```N``` - количество минут. Напишите код, который будет конвертировать минуты в кол-во годов и месяцев.

**Ответ** Должен содержать два числа: первое чилос - целые годы и второе число - целые месяцы. Возможны ответы в формате "10 5" и "3 года и 1 месяц".

--------
Пример: 

```
Входные данные:
38578378

Ответ:
73 4
```

> P.S. 
> Для простоты обозначим, что в месяце 30 дней, а в году 360 (не смотрим на реальное кол-во в календаре). Если хочется усложнить - можно считать реальные месяца и года с начала unix time stamp, это 1 января 1970 00:00.
> 
> Про формат - сначала нужно вывести кол-во лет, потом кол-во доп месяцев (которые не в ходят в предыдущие года). Например, N минут будет 10 лет и 5 месяцев.
> Причем важно, что остаток в виде 29 дней - не засчитывается за месяц, а 30 - уже да
