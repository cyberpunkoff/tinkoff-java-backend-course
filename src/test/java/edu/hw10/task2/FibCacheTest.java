package edu.hw10.task2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FibCacheTest {
    @Test
    void testSaveInCache() {
        FibCalculator c = new FibCalculatorImpl();
        FibCalculator proxy = CacheProxy.create(c, c.getClass());

        long start = System.nanoTime();
        proxy.fib(10);
        long finish = System.nanoTime();

        long start1 = System.nanoTime();
        proxy.fib(10);
        long finish1 = System.nanoTime();

        assertThat((finish1 - start1) < (finish - start)).isTrue();
    }
}
