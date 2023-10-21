package edu.project1.game;

import edu.project1.dictionary.Dictionary;
import edu.project1.dictionary.TextFileDictionary;
import edu.project1.exceptions.LetterGuessedException;
import edu.project1.exceptions.LetterGuessedWrongException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameRunner {
    private final static Logger LOGGER = LogManager.getLogger();
    private final Dictionary dictionary;
    private final InputReader input;

    public GameRunner() {
        input = new InputReader();
        try {
            dictionary = new TextFileDictionary();
        } catch (IOException | URISyntaxException e) {
            LOGGER.error("Ошибка чтения файла!");
            throw new RuntimeException(e);
        }
    }

    public GameRunner(InputStream inputStream, Dictionary dictionary) {
        input = new InputReader(inputStream);
        this.dictionary = dictionary;
    }

    public void run() {
        String word = dictionary.getRandomWord();
        Session gameSession = new Session(word);

        LOGGER.info(String.format("Сейчас вам будет загадано слово из %d букв%n", word.length()));
        Printer.print(gameSession);

        while (!gameSession.isGameOver()) {
            char letter = input.getLetter();

            if (letter == '~') {
                LOGGER.info("Выход из игры...");
                System.exit(0);
            }

            try {
                if (gameSession.guess(letter)) {
                    LOGGER.info("Вы угадали букву!");
                } else {
                    LOGGER.info("Вы не угадали букву!");
                }
            } catch (LetterGuessedException exception) {
                LOGGER.info("Вы уже угадали эту букву!");
                continue;
            } catch (LetterGuessedWrongException exception) {
                LOGGER.info("Вы уже пробовали эту букву!");
                continue;
            }
            Printer.print(gameSession);
        }

        if (gameSession.isWordGuessed()) {
            LOGGER.info("Вы победили!");
        } else {
            LOGGER.info("Вы проиграли!");
            LOGGER.info("Было загадано слово " + gameSession.getWord().getWord());
        }
    }

    public void setup() {
        LOGGER.info("Загрзите словарь! Каждое слово должно начинаться с новой строки.");
        LOGGER.info("Файл словаря должен находиться в одной папке с игрой");

        /*boolean fileReadSuccessful = false;
        while (!fileReadSuccessful) {
            try {
                TextFileDictionary.loadWords(input.getFilename());
                fileReadSuccessful = true;
            } catch (IOException exception) {
                System.out.println("Ошибка чтения файла!");
            } catch (NullPointerException exception) {
                System.out.println("Файл не найден");
            }
        }*/

        LOGGER.info("----------------- ВИСЕЛИЦА -----------------");
        LOGGER.info("Добро пожаловать в игру виселица!");
        LOGGER.info("Вам нужно будет постараться отгадать загаданное слово меньше чем за шесть ошибок!");
        LOGGER.info("Вы готовы начать?");

        while (input.getChoice()) {
            LOGGER.info("Чтобы выйти из игры введите EXIT");
            LOGGER.info("Начнем игру!");
            run();
            LOGGER.info("Хотите сыграть еще раз?");
        }
        LOGGER.info("Хорошего дня!");
    }
}
