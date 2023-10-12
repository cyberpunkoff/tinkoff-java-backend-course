package edu.project1;

import edu.project1.exceptions.LetterGuessedException;
import edu.project1.exceptions.LetterGuessedWrongException;
import java.io.IOException;

public class Game {

    InputReader input;

    Game() {
        input = new InputReader();
    }

    public void game() {

        // при количестве ошибок больше шести игра заканчивается
        int mistakesCounter = 0;

        String wordFromDictionary = Dictionary.getWord();
        Word word = new Word(wordFromDictionary);

        System.out.printf("Сейчас вам будет загадано слово из %d букв%n", word.length());
        Printer.print(word, mistakesCounter);

        while (mistakesCounter < 6 && !word.isGuessed()) {

            char letter = input.getLetter();

            try {
                if (word.checkLetter(letter)) {
                    System.out.println("Вы угадали букву!");
                } else {
                    mistakesCounter++;
                    System.out.println("Вы не угадали букву!");
                }
            } catch (LetterGuessedException exception) {
                System.out.println("Вы уже угадали эту букву!");
                continue;
            } catch (LetterGuessedWrongException exception) {
                System.out.println("Вы уже пробовали эту букву!");
                continue;
            }
            Printer.print(word, mistakesCounter);
        }

        if (mistakesCounter < 6) {
            System.out.println("Вы победили!");
        } else {
            System.out.println("Вы проиграли!");
            System.out.println("Было загадано слово " + word.getWord());
        }
    }

    public void setup() {
        System.out.println("Загрзите словарь! Каждое слово должно начинаться с новой строки.");
        System.out.println("Файл словаря должен находиться в одной папке с игрой");

        boolean fileReadSuccessful = false;
        while (!fileReadSuccessful) {
            try {
                Dictionary.loadWords(input.getFilename());
                fileReadSuccessful = true;
            } catch (IOException exception) {
                System.out.println("Ошибка чтения файла!");
            } catch (NullPointerException exception) {
                System.out.println("Файл не найден");
            }
        }

        System.out.println("----------------- ВИСЕЛЬНИЦА -----------------");
        System.out.println("Добро пожаловать в игру висельница!");
        System.out.println("Вам нужно будет постараться отгадать загаданное слово меньше чем за шесть ошибок!");
        System.out.println("Вы готовы начать?");

        while (input.getChoice()) {
            System.out.println("Начнем игру!");
            game();
            System.out.println("Хотите сыграть еще раз?");
        }
        System.out.println("Хорошего дня!");
    }
}
