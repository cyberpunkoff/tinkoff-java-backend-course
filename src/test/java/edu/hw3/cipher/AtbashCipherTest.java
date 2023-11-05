package edu.hw3.cipher;

import edu.hw3.cipher.AtbashCipher;
import edu.hw3.cipher.Cipher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class AtbashCipherTest {
    static Cipher cipher;

    @BeforeAll
    static void createCipher() {
        cipher = new AtbashCipher();
    }

    @DisplayName("Тестирование шифрования строки")
    @ParameterizedTest
    @CsvSource({
        "\"Hello world!\", \"Svool dliow!\"",
        "\"Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler\", " +
        "\"Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi\""
    })
    void testEncode(String input, String expected) {
        // when
        String result = cipher.encode(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("Шифрование и расшифровка дают одинаковый результат")
    @ParameterizedTest
    @CsvSource({"-----", "One more test, please!"})
    void testEncodeEqualsDecode(String input) {
        String encoded = cipher.encode(input);
        String decoded = cipher.decode(encoded);

        assertThat(decoded).isEqualTo(input);
    }
}
