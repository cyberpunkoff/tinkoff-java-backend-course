package edu.hw6.task3;

import edu.hw6.task3.filters.AbstractFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.task3.filters.FileNameFilter.globMatches;
import static edu.hw6.task3.filters.FileNameFilter.regexContains;
import static edu.hw6.task3.filters.FileSizeFilter.largerThan;

public class FiltersTestDrive {
    public static void main(String[] args) throws IOException {
        final AbstractFilter regularFile = Files::isRegularFile;
        final AbstractFilter readable = Files::isReadable;

        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
            .and(largerThan(100_000))
            .and(globMatches("*.png"))
            .and(regexContains("-2"));

        Path dir = Path.of("/Users/cyberpunkoff/Desktop/cats");

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter)) {
            entries.forEach(System.out::println);
        }

    }
}
