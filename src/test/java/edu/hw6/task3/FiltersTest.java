package edu.hw6.task3;

import edu.hw6.task3.filters.AbstractFilter;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static edu.hw6.task3.filters.FileNameFilter.globMatches;
import static edu.hw6.task3.filters.FileNameFilter.regexContains;
import static edu.hw6.task3.filters.FileSizeFilter.largerThan;
import static org.assertj.core.api.Assertions.assertThat;

public class FiltersTest {
    @Test
    void testFilter() throws IOException {
        final AbstractFilter regularFile = Files::isRegularFile;
        final AbstractFilter readable = Files::isReadable;

        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
            .and(largerThan(100_000))
            .and(globMatches("*.png"))
            .and(regexContains("-2"));

        Path dir = Path.of("src/main/resources/edu/hw6/task3/cats");

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter)) {
            List<String> result = new ArrayList<>();
            entries.forEach(path -> result.add(path.toString()));
            assertThat(result).containsExactly(dir.toString() + "/cat-2.png");
        }

    }
}
