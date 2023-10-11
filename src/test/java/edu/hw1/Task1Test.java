package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Длина видео - плохой ввод")
    void convertVideoLengthBadInput() {
        String duration = "10:1337";

        int secondsDuration = Task1.minutesToSeconds(duration);

        assertThat(secondsDuration).isEqualTo(-1);
    }

    @Test
    @DisplayName("Длина видео")
    void convertVideoLength() {
        String duration = "10:10";

        int secondsDuration = Task1.minutesToSeconds(duration);

        assertThat(secondsDuration).isEqualTo(610);
    }
}
