package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @DisplayName("Сломанная строка")
    @ParameterizedTest
    @CsvSource({
        "123456, 214365",
        "оПомигети псаривьтс ртко!и, Помогите исправить строки!"
    })
    void fixStringTest(String input, String expected) {
        String fixedString = Task4.fixString(input);

        assertThat(fixedString).isEqualTo(expected);
    }
}
