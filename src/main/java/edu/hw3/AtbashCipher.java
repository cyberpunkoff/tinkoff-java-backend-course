package edu.hw3;

public final class AtbashCipher implements Cipher {
    public String encode(String input) {
        return swapLetters(input);
    }

    public String decode(String input) {
        return swapLetters(input);
    }

    private static String swapLetters(String input) {
        StringBuilder result = new StringBuilder();

        for (char letter : input.toCharArray()) {
            if (isEnglishLetter(letter)) {
                result.append(getOppositeLetter(letter));
            } else {
                result.append(letter);
            }
        }

        return result.toString();
    }

    private static boolean isEnglishLetter(char letter) {
        return (letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z');
    }

    private static char getOppositeLetter(char letter) {
        if (letter >= 'a' && letter <= 'z') {
            return (char) ('z' - (letter - 'a'));
        } else {
            return (char) ('Z' - (letter - 'A'));
        }
    }
}
