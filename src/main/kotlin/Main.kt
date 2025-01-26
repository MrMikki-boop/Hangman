package org.example


fun main() {
    println("Добро пожаловать в игру Виселица!")

    val words = listOf("альтернатива", "виселица", "компьютер", "программа", "проект", "интерфейс", "класс")
    val chosenWord = words.random()

    println("Слово для игры: ${chosenWord}")
}