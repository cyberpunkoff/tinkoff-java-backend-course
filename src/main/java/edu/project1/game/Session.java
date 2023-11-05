package edu.project1.game;

public class Session {
    private final Word word;
    private static final int MAX_MISTAKES_AMOUNT = 5;
    private int attempts;

    public Session(String word) {
        this.word = new Word(word);
    }

    public Word getWord() {
        return word;
    }

    public boolean isGameOver() {
        return word.getMistakesCounter() > MAX_MISTAKES_AMOUNT || word.isGuessed();
    }

    public boolean isWordGuessed() {
        return word.isGuessed();
    }

    public int getMistakesCounter() {
        return word.getMistakesCounter();
    }

    public boolean guess(Character letter) {
        boolean result = word.checkLetter(letter);
        attempts++;
        return result;
    }

}
