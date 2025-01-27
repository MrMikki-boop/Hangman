package org.example



fun main() {
    println("Добро пожаловать в игру Виселица!")
    println("Правила игры: угадайте слово, вводя буквы. У вас есть 4 ошибки, после чего игра завершится. Удачи!\n")
    Thread.sleep(2000)

    val words = listOf("альтернатива", "виселица", "компьютер", "программа", "проект", "интерфейс", "класс")
    val chosenWord = words.random()
    var currentWord = "*".repeat(chosenWord.length)

    val guessedLetters = mutableSetOf<Char>()

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
        Thread.sleep(500)

        if (input == null || input.length != 1) {
            println("Некорректный ввод. Пожалуйста, введите одну букву.")
            continue
        }


        val letter = input[0]

        if (letter in guessedLetters) {
            println("Вы уже вводили эту букву. Пожалуйста, выберите другую букву.")
            continue
        }

        guessedLetters.add(letter)

        if (letter in chosenWord) {
            currentWord = revealLetter(chosenWord, currentWord, letter)
            println("Вы угадали букву: $currentWord")
        } else {
            mistakes++
            println("Неправильная буква. Осталось ${maxMistakes - mistakes} попыток.")
            if (mistakes <= hangmanStages.size) {
                println(hangmanStages[mistakes])
            }
        }
    }

    if (currentWord == chosenWord) {
        println("Поздравляем! Вы угадали слово: $chosenWord")
    } else {
        println("Вы проиграли. Правильное слово: $chosenWord")
    }

    Thread.sleep(1000)
    println("\nХотите сыграть ещё раз? (да/нет)")
    val playAgain = readLine()?.lowercase()
    if (playAgain == "да") {
        main() // Перезапуск игры
    } else {
        println("\nСпасибо за игру в Виселицу! Надеюсь, вы поВИСЕЛИлись! \nДо встречи!")
    }
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