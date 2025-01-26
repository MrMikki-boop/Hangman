package org.example


fun main() {
    println("Добро пожаловать в игру Виселица!")

    val words = listOf("альтернатива", "виселица", "компьютер", "программа", "проект", "интерфейс", "класс")
    val hiddenWord = hideWord(words.random())

    println("Слово для игры: $hiddenWord")
}

fun hideWord(word: String): String {
    return word.replaceRange(0, word.length, "*".repeat(word.length))
}