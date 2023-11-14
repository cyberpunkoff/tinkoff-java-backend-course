package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    @ParameterizedTest
    @CsvSource({
        "111, true",
        "01, false",
        "10111, true"
    })
    @DisplayName("Строка нечетной длины")
    void firstRegexTest(String input, boolean expected) {
        boolean result = Task8.firstRegex(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "1111, true",
        "111, false",
        "010, true",
        "01, false"
    })
    @DisplayName("Строка начинается с 0 и имеет нечетную длину, или начинается с 1 и имеет четную длину")
    void secondRegexTest(String input, boolean expected) {
        boolean result = Task8.secondRegex(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "1111, true",
        "111, false",
        "11, false",
        "1, true",
        "0111, true"
    })
    @DisplayName("Любая строка, кроме 11 или 111")
    void fourthRegexTest(String input, boolean expected) {
        boolean result = Task8.fourthRegex(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "1111, false",
        "111, false",
        "11, false",
        "101, true",
        "010101, true"
    })
    @DisplayName("В строке нет последовательных 1")
    void seventhRegexTest(String input, boolean expected) {
        boolean result = Task8.seventhRegex(input);

        assertThat(result).isEqualTo(expected);
    }
}
