package edu.hw7.task2;

import java.util.stream.IntStream;

public final class ParallelFactorial {
    private ParallelFactorial() {
    }

    public static int calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return 1;
        } else {
            return IntStream.rangeClosed(1, n).parallel().reduce(1, (x, y) -> x * y);
        }
    }
}
