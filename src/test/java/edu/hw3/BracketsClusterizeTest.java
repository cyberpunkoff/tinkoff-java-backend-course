package edu.hw3;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class BracketsClusterizeTest {
    static Stream<Arguments> bracketsTestSource() {
        return Stream.of(
            Arguments.of("()()()", List.of("()", "()", "()")),
            Arguments.of("((()))", List.of("((()))")),
            Arguments.of("((()))(())()()(()())", List.of("((()))", "(())", "()", "()", "(()())")),
            Arguments.of("((())())(()(()()))", List.of("((())())", "(()(()()))"))
        );
    }
    @ParameterizedTest
    @MethodSource("bracketsTestSource")
    void testClusterize(String input, List<String> expected) {
        // given

        // when
        List<String> result = BracketsClusterize.clusterize(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
