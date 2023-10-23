package edu.project1.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.assertj.core.api.Assertions.assertThat;

public class InputReaderTest {
    @Test
    @DisplayName("Тестирование получения буквы")
    void getLetterTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("Я\n".getBytes());
        InputReader inputReader = new InputReader(in);

        char letter = inputReader.getLetter();

        assertThat(letter).isEqualTo('Я');
    }

    @Test
    void getChoiceTest() {
        ByteArrayInputStream in = new ByteArrayInputStream("да\n".getBytes());
        InputReader inputReader = new InputReader(in);

        boolean result = inputReader.getChoice();

        assertThat(result).isTrue();
    }
}
