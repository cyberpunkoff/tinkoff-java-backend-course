package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @DisplayName("Количество цифр")
    @ParameterizedTest
    @CsvSource({
        "12, 2",
        "0, 1"
    })
    void countDigits(int number, int expected) {
        int digitsAmount = Task2.countDigits(number);

        assertThat(digitsAmount).isEqualTo(expected);
    }
}
