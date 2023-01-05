# HW-13 Kotlin Gradle DSL

Вам будет выдано небольшое текстовое условие со списком необходимых требований к проекту на gradle. Здесь не нужно
реализовать файлы с расширением .kt, работаем только в Kotlin Gradle DSL. Нужно будет создать небольшой проект,
удовлетворяющий всем требованиям.

Проект должен удовлетворять требованиям ниже. Рекомендуется выполнять требования в предложенном порядке:

> Далее все запуски gradle wrapper будут использоваться через `./gradlew ...`, но если у вас Windows вы можете запускать через `gradlew.bat ...`
### Инициализировать стандартный пустой gradle проект

Необходимо:
- Наличие файлов в корне (`gradle/wrapper/gradle-wrapper.jar`, `gradle/wrapper/gradle-wrapper.properties`, `.gitignore`, `build.gradle.kts`, `gradle.properties`, `gradlew`, `gradlew.bat`, `log.txt`, `README.md`, `settings.gradle.kts`) 
- Успешный запуск `./gradlew build`
- Наличие плагина `kotlin("jvm")`
- Если отдельно установлен gradle, проверить что версия `gradlew --version` совпадает с `gradle --version`
- Запустите `./gradlew wrapper --gradle-version` чтобы обновить версию gradle wrapper до 7.6 и проверить её в `gradle/wrapper/gradle-wrapper.properties`
- Запустите еще раз `./gradlew --version` чтобы проверить версию

### Создание кастомных задач

Необходимо:
- Создать задачу для вывода `Hello world` в консоль (**только при запуске этой задачи**)
- Создать задачу для увеличения версии проекта. Для этого структура версии должна быть типа `0.0.0` и задача должна увеличивать последнее число в версии.
Например, если из версии `1.12.3` получится `1.12.4`
- Создайте задачу `log-meta`, которая будет запускаться сразу после `build` и выводить мета-информацию про текущие group, version, artifactId и время запуска

### Добавление библиотек:

Добавьте следующие библиотеки:
- Gson - https://github.com/google/gson
- Kotlin html - https://kotlinlang.org/docs/typesafe-html-dsl.html
- Kotlin serialisation - https://kotlinlang.org/docs/serialization.html
- Проверьте что `./gradlew build` успешно работает и зависимости видны в исходном коде и при запуске `./gradlew dependencies`
- Создайте задачу `fat-jar`, которая упакует все зависимости в один `.jar` файл

### Вынесение всех версий в `gradle.properties`:
- Зафиксируйте все версии бибилиотек и плагинов в отдельном файле и подтягивайте их как переменные

### Добавление версий языков:
- Зафиксируйте версии:
  - У Java source и target должен стоят 11 (если у вас локально стоит 1.8, то можно выставить на 1.8)
  - У Kotlin jvmTarget должен быть такой же как и версия Java, language version и api version должны быть 1.6, а также добавлен compile arg `-Xjvm-default=enable`
