package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.FilenameUtils;

public final class FileCloner {
    private static final String FIRST_COPY_PATTERN = "%s — копия";
    private static final String NEXT_COPY_PATTERN = "%s — копия (%d)";

    private FileCloner() {
    }

    public static void clonePath(Path path) {
        Path originalPath = path.toAbsolutePath();
        Path copy = path.toAbsolutePath();
        int copyCount = 1;

        while (Files.exists(copy)) {
            String newFileName = generateNewFilename(originalPath.getFileName().toString(), copyCount);
            copy = originalPath.getParent().resolve(newFileName);
            copyCount++;
        }

        try {
            Files.copy(originalPath, copy);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generateNewFilename(String oldName, int copyCount) {
        String extension = FilenameUtils.getExtension(oldName);
        String fileName = FilenameUtils.removeExtension(oldName);
        StringBuilder result = new StringBuilder();

        if (copyCount == 1) {
            result.append(String.format(FIRST_COPY_PATTERN, fileName));
        } else {
            result.append(String.format(NEXT_COPY_PATTERN, fileName, copyCount));
        }

        if (!extension.isEmpty()) {
            result.append('.');
            result.append(extension);
        }

        return result.toString();
    }
}
