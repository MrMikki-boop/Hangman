# Виселица (Hangman)

## Описание

"Виселица" — это консольная игра, в которой игроку нужно угадать загаданное слово, вводя буквы по одной. У игрока есть
ограниченное количество попыток для того, чтобы угадать слово, иначе он проигрывает.

## Правила игры

1. При старте игры игроку показывается слово в виде “*****”, где каждая “*” — это скрытая буква.
2. Игрок вводит буквы по одной.
3. Если буква есть в слове, она открывается на всех соответствующих позициях.
4. Если буквы нет в слове, добавляется элемент виселицы.
5. У игрока есть 4 попытки. После этого он проигрывает.
6. Если игрок угадывает всё слово до окончания попыток, он выигрывает.

Пример хода игры:

```
Добро пожаловать в игру Виселица!
Правила игры: угадайте слово, вводя буквы. У вас есть 4 ошибки, после чего игра завершится. Удачи!

Слово для игры: ********
Введите букву:
а
Вы угадали букву: *******а
Слово для игры: *******а
Введите букву:
м
Неправильная буква. Осталось 3 попыток.
|
|
Слово для игры: *******а
Введите букву:
в
Вы угадали букву: в******а
Слово для игры: в******а
Введите букву:
...
```

## Функциональность

- Генерация случайного слова из заранее заданного списка.
- Отображение прогресса игры: угаданные буквы и виселица.
- Проверка правильности ввода (только одна буква за раз).
- Отслеживание введённых букв, чтобы избежать повторов.
- Возможность сыграть снова после окончания игры.

## Как запустить

1. Убедитесь, что у вас установлен [Kotlin](https://kotlinlang.org/) и подходящая среда разработки,
   например [IntelliJ IDEA](https://www.jetbrains.com/idea/).
2. Склонируйте репозиторий проекта:
   ```
   git clone https://github.com/MrMikki-boop/Hangman.git
   ```
3. Откройте проект в IntelliJ IDEA.
4. Запустите файл `Main.kt`.
5. Следуйте инструкциям в консоли.

## Структура проекта

- **`Main.kt`**: Главный файл с реализацией логики игры.
- **Список слов**: Находится внутри кода и может быть дополнен новыми словами по вашему желанию.

## Лицензия

Проект создавался для учебных целей и может свободно использоваться в личных и образовательных проектах.