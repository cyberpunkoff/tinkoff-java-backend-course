package edu.project1;

import edu.project1.exceptions.LetterGuessedException;
import edu.project1.exceptions.LetterGuessedWrongException;
import edu.project1.game.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordTest {
    @DisplayName("Угадывание буквы")
    @Test
    void guessLetterTest() {
        Word word = new Word("ТЕСТ");

        boolean result = word.checkLetter('Т');

        assertThat(result).isTrue();
    }

    @DisplayName("Проверка уже угаданной буквы")
    @Test
    void letterAlreadyGuessedTest() {
        Word word = new Word("ТЕСТ");

        word.checkLetter('Т');

        assertThrows(LetterGuessedException.class, () -> word.checkLetter('Т'));
    }

    @DisplayName("Проверка уже угаданной неправильно буквы")
    @Test
    void letterAlreadyGuessedWrongTest() {
        Word word = new Word("ТЕСТ");

        word.checkLetter('Ы');

        assertThrows(LetterGuessedWrongException.class, () -> word.checkLetter('Ы'));
    }
}
