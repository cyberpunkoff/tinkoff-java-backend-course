package edu.hw9.task2;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import org.junit.jupiter.api.Test;

public class DirectorySearchTaskTest {
    @Test
    void findAllDirectoriesTest() {
        try (ForkJoinPool forkJoinPool = new ForkJoinPool(8)) {

            DirectorySearchTask directorySearchTask = new DirectorySearchTask(Path.of("/Users/cyberpunkoff/"));
            forkJoinPool.execute(directorySearchTask);
            List<Path> directories = directorySearchTask.join();

            System.out.println(directories);
        }
    }
}
