package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    static Stream<Arguments> isSubstringTestSource() {
        return Stream.of(
            Arguments.of("achfdbaabgabcaabg", "abc", true),
            Arguments.of("lol", "no", false)
        );
    }

    @ParameterizedTest
    @MethodSource("isSubstringTestSource")
    void testIsSubstring(String input, String search, boolean expected) {
        boolean result = Task6.isSubstring(input, search);

        assertThat(result).isEqualTo(expected);
    }
}
