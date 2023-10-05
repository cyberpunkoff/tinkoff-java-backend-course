package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    @DisplayName("Количество цифр 1")
    void countDigitsOfTwelve() {
        int number = 12;

        int digitsAmount = Main.countDigits(number);

        assertThat(digitsAmount).isEqualTo(2);
    }

    @Test
    @DisplayName("Количество цифр 2")
    void countDigitsOfZero() {
        int number = 0;

        int digitsAmount = Main.countDigits(number);

        assertThat(digitsAmount).isEqualTo(1);
    }

    @Test
    @DisplayName("Вложенный массив")
    void isNestableArrayTrue() {
        int[] firstArray = new int[] {1, 2, 3, 4};
        int[] secondArray = new int[] {0, 6};

        boolean isNestable = Main.isNestable(firstArray, secondArray);

        assertThat(isNestable).isEqualTo(true);
    }

    @Test
    @DisplayName("Вложенный массив 1")
    void isNestableArrayFalse() {
        int[] firstArray = new int[] {9, 9, 8};
        int[] secondArray = new int[] {8, 9};

        boolean isNestable = Main.isNestable(firstArray, secondArray);

        assertThat(isNestable).isEqualTo(false);
    }

    @Test
    @DisplayName("Сломанная строка 1")
    void fixStringTestOne() {
        String input = "123456";

        String fixedString = Main.fixString(input);

        assertThat(fixedString).isEqualTo("214365");
    }

    @Test
    @DisplayName("Сломанная строка 2")
    void fixStringTestTwo() {
        String input = "оПомигети псаривьтс ртко!и";

        String fixedString = Main.fixString(input);

        assertThat(fixedString).isEqualTo("Помогите исправить строки!");
    }

    @Test
    @DisplayName("Особый палиндром 1")
    void checkPalindromeStringOne() {
        int input = 11211230;

        boolean result = Main.isPalindromeDescendant(input);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Особый палиндром 2")
    void checkPalindromeStringTwo() {
        int input = 23336014;

        boolean result = Main.isPalindromeDescendant(input);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Особый палиндром 3")
    void checkPalindromeStringThree() {
        int input = 7778;

        boolean result = Main.isPalindromeDescendant(input);

        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("Циклический битовый сдвиг вправо")
    void rotateRightCheck() {
        int input = 8;

        int result = Main.rotateRight(input, 1);

        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("Циклический битовый сдвиг влево")
    void rotateLeftCheck() {
        int input = 16;

        int result = Main.rotateLeft(input, 1);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("Кони на доске")
    void knightsTest() {
        int[][] deck = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        boolean result = Main.knightBoardCapture(deck);

        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("Кони на доске 1")
    void knightsTestTwo() {
        int[][] deck = {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        boolean result = Main.knightBoardCapture(deck);

        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("Постоянная Капрекара 1")
    void countKTestOne() {
        int n = 6621;

        int result = Main.countK(n);

        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("Постоянная Капрекара 2")
    void countKTestTwo() {
        int n = 6554;

        int result = Main.countK(n);

        assertThat(result).isEqualTo(4);
    }
}
