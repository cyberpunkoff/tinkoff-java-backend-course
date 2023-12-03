package edu.hw8.task2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FixedThreadPoolTest {
    @Test
    void fixedThreadPoolTest() {
        try (ThreadPool pool = new FixedThreadPool(4)) {
            pool.execute(() -> assertThat(calculateFib(0)).isEqualTo(1));
            pool.execute(() -> assertThat(calculateFib(1)).isEqualTo(1));
            pool.execute(() -> assertThat(calculateFib(2)).isEqualTo(2));
            pool.execute(() -> assertThat(calculateFib(3)).isEqualTo(3));
            pool.execute(() -> assertThat(calculateFib(4)).isEqualTo(5));
            pool.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private long calculateFib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return calculateFib(n - 1) + calculateFib(n - 2);
    }
}
