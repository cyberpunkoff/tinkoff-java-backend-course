package edu.hw6.task3.filters;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    @Override
    boolean accept(Path entry) throws IOException;

    default AbstractFilter and(AbstractFilter next) {
        return entry -> accept(entry) && next.accept(entry);
    }
}
