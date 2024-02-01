package edu.hw7.task2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class ParallelFactorialTest {
    @ParameterizedTest
    @CsvSource({
        "0,1",
        "3,6",
        "5,120"
    })
    void testCalculateFactorial(int input, int expected) {
        assertThat(ParallelFactorial.calculateFactorial(input)).isEqualTo(expected);
    }
}
