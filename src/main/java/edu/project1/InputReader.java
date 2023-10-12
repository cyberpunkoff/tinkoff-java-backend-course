package edu.project1;

import java.util.Scanner;

public class InputReader {
    private final Scanner inputStream;

    InputReader() {
        inputStream = new Scanner(System.in);
    }

    private static boolean isLetterCorrect(char letter) {
        String russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        return russianAlphabet.indexOf(letter) != -1;
    }

    public char getLetter() {

        System.out.print("Введите букву: ");
        String userInput = inputStream.next().toUpperCase();

        if (userInput.length() > 1 || userInput.isBlank()) {
            System.out.println("Введите ровно одну букву!");
            return getLetter();
        }

        char letter = userInput.charAt(0);

        if (isLetterCorrect(letter))
            return letter;

        System.out.println("Введите букву русского алфавита!");
        return getLetter();

    }

    public String getFilename() {
        System.out.print("Введите имя файла: ");
        String filename = inputStream.next();
        return filename;
    }

    public boolean getChoice() {
        System.out.print("Сделайте выбор (да/нет): ");
        String userInput = inputStream.next().toLowerCase();
        if (userInput.equals("да"))
            return true;
        if (userInput.equals("нет"))
            return false;
        return getChoice();
    }
}
