package edu.project3.logloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

public class LocalFileLogLoader implements LogLoader {
    private List<String> records;
    private List<String> fileNames;

    public LocalFileLogLoader(String path) {
        records = new ArrayList<>();
        fileNames = new ArrayList<>();
        searchFiles(".", path);
    }

    private void searchFiles(String basePath, String pattern) {
        File baseDir = new File(basePath);
        WildcardFileFilter fileFilter = new WildcardFileFilter(pattern);
        Collection<File> files = FileUtils.listFiles(baseDir, fileFilter, DirectoryFileFilter.DIRECTORY);

        files.forEach(file -> {
                fileNames.add(file.toPath().getFileName().toString());
                parseFile(file.toPath());
            });
    }

    private void parseFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            records.addAll(reader.lines().toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> getLogRecords() {
        return records;
    }

    @Override
    public List<String> getFileNames() {
        return fileNames;
    }
}
