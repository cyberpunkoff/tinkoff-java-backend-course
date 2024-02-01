package edu.hw9.task2;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FileSearchTaskTest {
    @Test
    void findFilesByFilterTest() {
        try (ForkJoinPool forkJoinPool = new ForkJoinPool(8)) {
            Predicate<Path> extensionPredicate = e -> e.getFileName().toString().endsWith(".boba");
            URL resource = getClass().getResource("/edu/hw9/task2/testFiles");
            Path path = Paths.get(resource.toURI());

            FileSearchTask directorySearchTask =
                new FileSearchTask(path, List.of(extensionPredicate));
            forkJoinPool.execute(directorySearchTask);
            List<Path> directories = directorySearchTask.join();

            List<Path> expected = List.of(path.resolve("a.boba"), path.resolve("subDir/b.boba"));
            assertThat(directories).containsExactlyElementsOf(expected);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
