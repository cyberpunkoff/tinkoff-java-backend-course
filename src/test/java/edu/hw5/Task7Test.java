package edu.hw5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @ParameterizedTest
    @CsvSource({
        "01, false",
        "100, true",
        "1010, false"
    })
    @DisplayName("Строка содержит не менее 3 символов, причем третий символ равен 0")
    void firstRegexTest(String input, boolean expected) {
        boolean result = Task7.firstRegex(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "01, false",
        "1001, true",
        "1010, false"
    })
    @DisplayName("Строка начинается и заканчивается одним и тем же символом")
    void secondRegexTest(String input, boolean expected) {
        boolean result = Task7.secondRegex(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "1, true",
        "1001, false",
        "101, true",
        "\"\", false"
    })
    @DisplayName("Cтрока имеет длину не менее 1 и не более 3")
    void thirdRegexTest(String input, boolean expected) {
        boolean result = Task7.thirdRegex(input);

        assertThat(result).isEqualTo(expected);
    }
}
