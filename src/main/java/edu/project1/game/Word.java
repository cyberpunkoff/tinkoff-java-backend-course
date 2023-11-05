package edu.project1.game;

import edu.project1.exceptions.LetterGuessedException;
import edu.project1.exceptions.LetterGuessedWrongException;
import java.util.HashSet;
import java.util.Set;

public class Word {
    private final String word;
    private final Set<Character> guessedLetters;
    private final Set<Character> guessedWrongLetters;

    public Word(String word) {
        this.word = word;
        guessedLetters = new HashSet<>();
        guessedWrongLetters = new HashSet<>();
    }

    public char charAt(int index) {
        return word.charAt(index);
    }

    public int length() {
        return word.length();
    }

    public String getWord() {
        return word;
    }

    public boolean isGuessed() {
        for (int i = 0; i < word.length(); i++) {
            if (!guessedLetters.contains(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isLetterGuessed(char letter) {
        return guessedLetters.contains(letter);
    }

    public boolean checkLetter(Character letter) throws LetterGuessedException, LetterGuessedWrongException {
        if (guessedLetters.contains(letter)) {
            throw new LetterGuessedException();
        }
        if (guessedWrongLetters.contains(letter)) {
            throw new LetterGuessedWrongException();
        }
        if (word.contains(letter.toString())) {
            guessedLetters.add(letter);
            return true;
        }
        guessedWrongLetters.add(letter);
        return false;
    }

    public int getMistakesCounter() {
        return guessedWrongLetters.size();
    }
}
