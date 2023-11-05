package edu.project1.game;

import edu.project1.game.Session;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class SessionTest {
    static Stream<Arguments> userInputArguments() {
        return Stream.of(
            Arguments.of("ПРОВЕРКА", "ПРОВЕКА".toCharArray(), true),
            Arguments.of("ПРОВЕРКА", "abcdef".toCharArray(), false)
        );
    }

    @DisplayName("Тестирование отгаданного слова")
    @ParameterizedTest
    @MethodSource("userInputArguments")
    void testGuessedWord(String word, char[] userInput, boolean expected) {
        Session session = new Session(word);

        for (char letter : userInput) {
            session.guess(letter);
        }

        assertThat(session.isWordGuessed()).isEqualTo(expected);
        assertThat(session.isGameOver()).isTrue();
    }
}
