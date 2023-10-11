package edu.hw1;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    private static Stream<Arguments> isNestableArrayTestParameters() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {0, 6}, true),
            Arguments.of(new int[] {9, 9, 8}, new int[] {8, 9}, false)
        );
    }

    @DisplayName("Вложенный массив")
    @ParameterizedTest
    @MethodSource("isNestableArrayTestParameters")
    void isNestableArray(int[] firstArray, int[] secondArray, boolean expected) {
        boolean isNestable = Task3.isNestable(firstArray, secondArray);

        assertThat(isNestable).isEqualTo(expected);
    }
}
