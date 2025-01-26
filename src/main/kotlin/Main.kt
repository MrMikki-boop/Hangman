package org.example


fun main() {
    println("Добро пожаловать в игру Виселица!")

    val words = listOf("альтернатива", "виселица", "компьютер", "программа", "проект", "интерфейс", "класс")

    val chosenWord = words.random()
    val hiddenWord = hideWord(chosenWord)
    var currentWord = "*".repeat(chosenWord.length)

    println("Слово для игры: $hiddenWord")

    println("Введите букву:")
    val input = readLine()?.lowercase()
    println("Вы ввели: $input")

    if (input != null && input in chosenWord) {
        currentWord = revealLetter(chosenWord, currentWord, input[0])
        println("Угаданное слово: $currentWord")

        if (currentWord == chosenWord) {
            println("Поздравляем, вы угадали слово!")
        }
    } else {
        println("Нет такой буквы!")
    }

}

fun hideWord(word: String): String {
    return word.replaceRange(0, word.length, "*".repeat(word.length))
}

fun revealLetter(word: String, currentWord: String, letter: Char): String {
    val updateWord = currentWord.toCharArray()
    for (i in word.indices) {
        if (word[i] == letter) {
            updateWord[i] = letter
        }
    }
    return String(updateWord)
}