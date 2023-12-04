package edu.hw6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DiskMapTest {
    private final Path filePath = Paths.get(DiskMap.FILE_NAME);
    private final Map<String, String> mapForTest = Map.of(
        "test", "1",
        "test2", "2"
    );

    @Test
    @DisplayName("Creating DiskMap file test")
    public void shouldCreateNewFileDiskMapFile() {
        new DiskMap().save();
        assertThat(Files.exists(filePath)).isTrue();
    }

    @Test
    @DisplayName("isEmpty method test")
    public void isEmpty_shouldReturnTrue_whenFileIsEmpty() {
        assertThat(new DiskMap().isEmpty()).isTrue();
    }

    @Test
    @DisplayName("put method test")
    public void put_shouldPutStringInCreatedFile() {
        DiskMap diskMap = new DiskMap();
        diskMap.put("test3", "3");
        diskMap.save();
        try {
            var lines = Files.readAllLines(filePath);
            assertThat(lines.contains("test3" + DiskMap.DELIMITER + "3")).isTrue();
        } catch (IOException ignored) {
        }
    }
}
