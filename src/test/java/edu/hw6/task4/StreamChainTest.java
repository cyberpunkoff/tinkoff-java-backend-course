package edu.hw6.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamChainTest {
    private final Path filePath = Paths.get(StreamChain.FILE_NAME);

    @Test
    @DisplayName("Creation of file")
    public void build_shouldCreateFile() {
        new StreamChain().build();
        assertThat(Files.exists(filePath)).isTrue();
    }

    @Test
    @DisplayName("Created file has correct message")
    public void build_shouldWriteMessageInCreatedFile() throws IOException {
        new StreamChain().build();
        assertThat(Files.readAllLines(filePath).get(0)).isEqualTo(StreamChain.MESSAGE);
    }
}
