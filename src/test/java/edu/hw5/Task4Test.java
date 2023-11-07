package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    static Stream<Arguments> checkPasswordTestSource() {
        return Stream.of(
            Arguments.of("test!", true),
            Arguments.of("anothertest", false),
            Arguments.of("!onemore&", true)
        );
    }

    @ParameterizedTest
    @MethodSource("checkPasswordTestSource")
    void testCheckPassword(String input, boolean expected) {
        boolean result = Task4.checkPassword(input);

        assertThat(result).isEqualTo(expected);

    }
}
