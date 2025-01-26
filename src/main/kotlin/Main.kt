package org.example



fun main() {
    println("Добро пожаловать в игру Виселица!")

    val words = listOf("альтернатива", "виселица", "компьютер", "программа", "проект", "интерфейс", "класс")
    val chosenWord = words.random()
    var currentWord = "*".repeat(chosenWord.length)

    var mistakes = 0
    val maxMistakes = 4

    val hangmanStages = listOf(
        "|",
        "|\n|",
        "/--------\n|",
        "/--------\n|         |\n|         *",
        "/--------\n|         |\n|         *\n|       /  \\\n|        / \\"
    )

    while (mistakes < maxMistakes && currentWord != chosenWord) {
        println("Слово для игры: $currentWord")
        println("Введите букву:")

        val input = readLine()?.lowercase()

        if (input != null && input.length == 1) {
            if (input[0] in chosenWord) {
                currentWord = revealLetter(chosenWord, currentWord, input[0])
                println("Угаданное слово: $currentWord")
            } else {
                mistakes++
                println("Неправильная буква. Осталось ошибок: ${maxMistakes - mistakes}")
                if (mistakes <= hangmanStages.size) {
                    println(hangmanStages[mistakes])
                }
            }
        } else {
            println("Некорректный ввод. Пожалуйста, введите одну букву.")
        }
    }

    if (currentWord == chosenWord) {
        println("Поздравляем! Вы угадали слово: $chosenWord")
    } else {
        println("Вы проиграли. Правильное слово: $chosenWord")
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