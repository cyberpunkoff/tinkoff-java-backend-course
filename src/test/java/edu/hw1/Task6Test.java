package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @DisplayName("Постоянная Капрекара")
    @ParameterizedTest
    @CsvSource({
        "6621, 5",
        "6554, 4"
    })
    void countKTest(int n, int expected) {
        int result = Task6.countK(n);

        assertThat(result).isEqualTo(expected);
    }
}
