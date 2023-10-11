package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Циклический битовый сдвиг вправо")
    void rotateRightCheck() {
        // given
        int input = 8;

        // when
        int result = Task7.rotateRight(input, 1);

        // then
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("Циклический битовый сдвиг влево")
    void rotateLeftCheck() {
        // given
        int input = 16;

        // when
        int result = Task7.rotateLeft(input, 1);

        // then
        assertThat(result).isEqualTo(1);
    }
}
