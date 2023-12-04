package edu.hw6.task3.filters;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.PathMatcher;

public abstract class FileNameFilter implements AbstractFilter {
    public static FileNameFilter globMatches(String globString) {
        return new FileNameFilter() {
            @Override
            public boolean accept(Path path) {
                if (globString.equals("*")) {
                    return true;
                }

                FileSystem fs = path.getFileSystem();
                PathMatcher matcher = fs.getPathMatcher("glob:" + globString);
                return matcher.matches(path.getFileName());
            }
        };
    }

    public static FileNameFilter regexContains(String regex) {
        return new FileNameFilter() {
            @Override
            public boolean accept(Path path) {
                return path.getFileName().toString().matches(".*" + regex + ".*");
            }
        };
    }
}
