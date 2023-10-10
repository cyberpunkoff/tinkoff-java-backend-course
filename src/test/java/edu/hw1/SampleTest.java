package edu.hw1;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SampleTest {
    @Test
    @DisplayName("Фильтрация четных чисел")
    void filterEvenNumbers() {
        // given
        int[] numbers = new int[] {1, 2, 3, 4, 5};

        // when
        int[] evenNumbers = EvenArrayUtils.filter(numbers);

        // then
        assertThat(evenNumbers)
            .containsExactly(2, 4)
            .hasSize(2);
    }

    @Test
    @DisplayName("Длина видео - плохой ввод")
    void convertVideoLengthBadInput() {
        String duration = "10:1337";

        int secondsDuration = Main.minutesToSeconds(duration);

        assertThat(secondsDuration).isEqualTo(-1);
    }

    @Test
    @DisplayName("Длина видео")
    void convertVideoLength() {
        String duration = "10:10";

        int secondsDuration = Main.minutesToSeconds(duration);

        assertThat(secondsDuration).isEqualTo(610);
    }

    @DisplayName("Количество цифр")
    @ParameterizedTest
    @CsvSource({
        "12, 2",
        "0, 1"
    })
    void countDigits(int number, int expected) {
        int digitsAmount = Main.countDigits(number);

        assertThat(digitsAmount).isEqualTo(expected);
    }

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
        boolean isNestable = Main.isNestable(firstArray, secondArray);

        assertThat(isNestable).isEqualTo(expected);
    }

    @DisplayName("Сломанная строка")
    @ParameterizedTest
    @CsvSource({
        "123456, 214365",
        "оПомигети псаривьтс ртко!и, Помогите исправить строки!"
    })
    void fixStringTest(String input, String expected) {
        String fixedString = Main.fixString(input);

        assertThat(fixedString).isEqualTo(expected);
    }

    @DisplayName("Особый палиндром")
    @ParameterizedTest
    @CsvSource({
        "11211230, true",
        "23336014, true",
        "7778, false"
    })
    void checkPalindromeStringOne(int input, boolean expected) {
        boolean result = Main.isPalindromeDescendant(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Циклический битовый сдвиг вправо")
    void rotateRightCheck() {
        // given
        int input = 8;

        // when
        int result = Main.rotateRight(input, 1);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("Циклический битовый сдвиг влево")
    void rotateLeftCheck() {
        // given
        int input = 16;

        // when
        int result = Main.rotateLeft(input, 1);

        // then
        assertThat(result).isEqualTo(1);
    }

    private static Stream<Arguments> knightsTestParameters() {
        return Stream.of(
            Arguments.of(new int[][] {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}
            }, true),
            Arguments.of(new int[][] {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}
            }, false)
        );
    }

    @DisplayName("Кони на доске")
    @ParameterizedTest
    @MethodSource("knightsTestParameters")
    void knightsTest(int[][] deck, boolean expected) {
        boolean result = Main.knightBoardCapture(deck);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("Постоянная Капрекара")
    @ParameterizedTest
    @CsvSource({
        "6621, 5",
        "6554, 4"
    })
    void countKTest(int n, int expected) {
        int result = Main.countK(n);

        assertThat(result).isEqualTo(expected);
    }
}
