### ДЗ-11

В соседнем файле [DslUnitTest.kt](DslUnitTest.kt) лежит тест для конечной реализации dls, эмитирующий генерацию SQL запроса.
Результат функций будет строка в комментарии

Также примеры можно найти ниже:

#### Простой select запрос:
Если select не указан - по стандарту используется `select *` 
```kotlin
// "select * from table"

query {
    from("table")
}
```

#### Ошибка для select-запроса без таблицы:
Если `from` не указан - ошибка, тк нужно указать из какой бд мы хотим получить данные

`from` - обязательный параметр
```kotlin
// Ошибка - select запрос нельзя сделать без указания таблицы

query {
    select("col_a")
}.build()
```

#### Запрос на несколько полей:
Возможность указывать несколько пар-ов в select - они передаются через запятую

```kotlin
//  "select col_a, col_b from table"

query {
    select("col_a", "col_b")
    from("table")
}
```

#### Запрос с указанием where:
Возможность указывать пар-тр where, в котором указывается параметр, значение и способ сравнивания

Способы сравнения:
- __eq__ is "equals" function. Must be one of char:
- \- for strings - `=`
- \- for numbers - `=`
- \- for null - `is`

```kotlin
// "select * from table where col_a = 'id'"

query {
    from("table")
    where { "col_a" eq "id" }
}
```

#### Запрос с указанием отрицания в where:
Возможность указывать пар-тр where, но передавать туда "отрицательные" функции сравнения

Способы сравнения:
- __nonEq__ is "non equals" function. Must be one of chars:
- \- for strings - `!=`
- \- for numbers - `!=`
- \- for null - `!is`
```kotlin
// "select * from table where col_a != 0"

query {
    from("table")
    where {
        "col_a" nonEq 0
    }
}
```

#### Комбинация параметров в where:

Можно указывать больше одного пар-тра в where только если указано как они между собой связаны

Способ связи:
- or - пишется как `or`
- and - пишется как `and`

```kotlin
// "select * from table where (col_a = 4 or col_b !is null)"

query {
    from("table")
    where {
        or {
            "col_a" eq 4
            "col_b" nonEq null
        }
    }
}
```

#### Запрос, использующий все фичи выше:

```kotlin
// "select (first_par, second_par) from table where (col_a = 4 and col_b !is null)"

query {
    select("first_par", "second_par")
    from("table")
    where {
        and {
            "col_a" eq 4
            "col_b" nonEq null
        }
    }
}
```
