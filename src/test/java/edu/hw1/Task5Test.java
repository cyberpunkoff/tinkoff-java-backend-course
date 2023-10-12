package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @DisplayName("Особый палиндром")
    @ParameterizedTest
    @CsvSource({
        "11211230, true",
        "23336014, true",
        "7778, false"
    })
    void checkPalindromeStringOne(int input, boolean expected) {
        boolean result = Task5.isPalindromeDescendant(input);

        assertThat(result).isEqualTo(expected);
    }
}
