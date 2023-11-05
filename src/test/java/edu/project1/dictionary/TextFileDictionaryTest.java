package edu.project1.dictionary;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import static org.assertj.core.api.Assertions.assertThat;

public class TextFileDictionaryTest {
    @Test
    @DisplayName("Получение случайного слова")
    void getRandomWordTest_shouldReturnWord() {
        // given
        Dictionary dictionary;
        try {
            dictionary = new TextFileDictionary();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        String word = dictionary.getRandomWord();

        assertThat(word.length()).isNotEqualTo(0);
    }
}
