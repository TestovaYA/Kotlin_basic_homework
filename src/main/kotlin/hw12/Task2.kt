package hw12

import java.io.File
import java.util.*

const val FILE_PATH_TRANSLATIONS = "docs/hw12/translations.txt"

val latinCharset = 'A'..'z'

val dictionaryEnRu = HashMap<String, List<String>>()
val dictionaryRuEn = HashMap<String, MutableList<String>>()

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите слово для перевода: ")
    val word = scanner.nextLine()

    val translations = getTranslations(word)

    if (translations.isEmpty()) println("В словаре нет перевода ")
    else println(translations.joinToString(", "))
}

fun getTranslations(word: String): List<String> {
    return if (word[0] in latinCharset) {
        if (dictionaryEnRu.isEmpty()) fillDictionaryEnRu()
        dictionaryEnRu[word] ?: mutableListOf()
    } else {
        if (dictionaryRuEn.isEmpty()) fillDictionaryRuEn()
        dictionaryRuEn[word] ?: listOf()
    }
}

fun fillDictionaryEnRu(): HashMap<String, List<String>> {
    File(FILE_PATH_TRANSLATIONS).forEachLine {
        val substrings = it.split(" - ")
        val wordEn = substrings[0]
        val wordsRu = substrings[1].split(",")

        dictionaryEnRu[wordEn] = wordsRu
    }

    return dictionaryEnRu
}

fun fillDictionaryRuEn(): HashMap<String, MutableList<String>> {
    File(FILE_PATH_TRANSLATIONS).forEachLine {
        val substrings = it.split(" - ")
        val wordEn = substrings[0]
        val wordsRu = substrings[1].split(",")

        wordsRu.forEach { wordRu ->
            if (dictionaryRuEn.containsKey(wordRu)) {
                if (!dictionaryRuEn[wordRu]!!.contains(wordEn)) dictionaryRuEn[wordRu]!!.add(wordEn)
            } else {
                dictionaryRuEn[wordRu] = mutableListOf(wordEn)
            }
        }
    }

    return dictionaryRuEn
}