package edu.hw3;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumbersTest {
    static Stream<Arguments> decimalToRomanTestArguments() {
        return Stream.of(
            Arguments.of(2, "II"),
            Arguments.of(12, "XII"),
            Arguments.of(16, "XVI")
        );
    }

    @ParameterizedTest
    @MethodSource("decimalToRomanTestArguments")
    void convertDecimalToRomanTest(int input, String expected) {
        String result = RomanNumbers.convertToRoman(input);

        assertThat(result).isEqualTo(expected);
    }
}
