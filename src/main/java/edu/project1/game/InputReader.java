package edu.project1.game;

import java.io.InputStream;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InputReader {
    private final static Logger LOGGER = LogManager.getLogger();
    private final Scanner inputStream;

    InputReader() {
        inputStream = new Scanner(System.in);
    }

    InputReader(InputStream inputStream) {
        this.inputStream = new Scanner(inputStream);
    }

    private static boolean isLetterCorrect(char letter) {
        String russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        return russianAlphabet.indexOf(letter) != -1;
    }

    public char getLetter() {
        LOGGER.info("Введите букву: ");
        String userInput = inputStream.next().toUpperCase();

        if (userInput.equals("EXIT")) {
            return '~'; // ~ как указатель на то, что пользователь решил выйти
        }

        if (userInput.length() > 1 || userInput.isBlank()) {
            LOGGER.info("Введите ровно одну букву!");
            return getLetter();
        }

        char letter = userInput.charAt(0);

        if (isLetterCorrect(letter)) {
            return letter;
        }

        LOGGER.info("Введите букву русского алфавита!");
        return getLetter();

    }

    public String getFilename() {
        LOGGER.info("Введите имя файла: ");
        return inputStream.next();
    }

    public boolean getChoice() {
        LOGGER.info("Сделайте выбор (да/нет): ");
        String userInput = inputStream.next().toLowerCase();
        if (userInput.equals("да")) {
            return true;
        }
        if (userInput.equals("нет")) {
            return false;
        }
        return getChoice();
    }
}
