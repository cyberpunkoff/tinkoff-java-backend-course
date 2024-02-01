package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FileSearchTask extends RecursiveTask<List<Path>>  {
    private Path path;
    private List<Predicate<Path>> predicates;

    public FileSearchTask(Path path, List<Predicate<Path>> predicates) {
        this.path = path;
        this.predicates = predicates;
    }

    @Override
    protected List<Path> compute() {
        if (!Files.isReadable(path)) {
            return List.of();
        }

        List<Path> found = new ArrayList<>();
        List<FileSearchTask> subTasks = new ArrayList<>();
        try (Stream<Path> entries = Files.list(path)) {
            for (var sub : entries.toList()) {
                if (Files.isDirectory(sub)) {
                    FileSearchTask subTask = new FileSearchTask(sub, predicates);
                    subTask.fork();
                    subTasks.add(subTask);
                } else {
                    if (predicates.stream().allMatch(p -> p.test(sub))) {
                        found.add(sub);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (var task : subTasks) {
            found.addAll(task.join());
        }

        return found;
    }
}
