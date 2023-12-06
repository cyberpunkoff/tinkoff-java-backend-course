package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Stream;

public class DirectorySearchTask extends RecursiveTask<List<Path>> {
    public static int TARGET_FILES_COUNT = 3;
    private Path path;

    public DirectorySearchTask(Path path) {
        this.path = path;
    }

    @Override
    protected List<Path> compute() {
        if (!Files.isReadable(path)) {
            return List.of();
        }

        List<Path> directories = new ArrayList<>();
        List<DirectorySearchTask> subTasks = new ArrayList<>();

        try (Stream<Path> entries = Files.list(path)) {
            int fileCounter = 0;
            for (var path : entries.toList()) {
                if (Files.isDirectory(path)) {
                    DirectorySearchTask subTask = new DirectorySearchTask(path);
                    subTask.fork();
                    subTasks.add(subTask);
                } else {
                    fileCounter++;
                }
            }

            if (fileCounter >= TARGET_FILES_COUNT) {
                directories.add(path);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (var task : subTasks) {
            directories.addAll(task.join());
        }

        return directories;
    }
}
