package org.example


fun main() {
    println("Добро пожаловать в игру Виселица!")

    val words = listOf("альтернатива", "виселица", "компьютер", "программа", "проект", "интерфейс", "класс")

    val chosenWord = words.random()
    val hiddenWord = hideWord(chosenWord)

    println("Слово для игры: $hiddenWord")

    println("Введите букву:")
    val input = readLine()?.lowercase()
    println("Вы ввели: $input")

    if (input != null && input in chosenWord) {
        println("Есть такая буква!")
    } else {
        println("Нет такой буквы!")
    }


}

fun hideWord(word: String): String {
    return word.replaceRange(0, word.length, "*".repeat(word.length))
}