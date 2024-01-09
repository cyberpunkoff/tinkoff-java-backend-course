package edu.hw6.task3.filters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class FileSizeFilter implements AbstractFilter {
    public static FileSizeFilter largerThan(long sizeInBytes) {
        return new FileSizeFilter() {
            @Override
            public boolean accept(Path path) {
                try {
                    long bytes = Files.size(path);
                    return bytes  > sizeInBytes;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
