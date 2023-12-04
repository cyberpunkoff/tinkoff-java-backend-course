package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileClonerTest {
    private final Path filePath = Paths.get("src/main/resources/edu/hw6/task2/tinkoff big secret.txt");
    private final Path copyPath = Paths.get("src/main/resources/edu/hw6/task2/tinkoff big secret — копия.txt");
    private final Path secondCopyPath = Paths.get("src/main/resources/edu/hw6/task2/tinkoff big secret — копия (2).txt");

    @BeforeEach
    void deleteCopies() throws IOException {
        Files.deleteIfExists(copyPath);
        Files.deleteIfExists(secondCopyPath);
    }

    @Test
    public void clonePath_shouldCreateFile() {
        FileCloner.clonePath(filePath);
        assertTrue(Files.exists(copyPath));
    }

    @Test
    public void clonePath_shouldCreateCopyOfFile() throws IOException {
        FileCloner.clonePath(filePath);
        var lines = Files.readAllLines(filePath);
        var copyLines = Files.readAllLines(copyPath);
        assertThat(lines).isEqualTo(copyLines);
    }

    @Test
    public void clonePath_shouldCreateSecondCopyOfFile() {
        FileCloner.clonePath(filePath);
        FileCloner.clonePath(filePath);
        assertThat(Files.exists(secondCopyPath)).isTrue();
    }
}
