package edu.hw7.task1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceIncrementor {
    private static final int AMOUNT_OF_THREADS = 4;
    private AtomicInteger count = new AtomicInteger();

    public void incrementTo(int incrementTo) {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < AMOUNT_OF_THREADS - 1; i++) {
            threads.add(startIncrementorThread(incrementTo / AMOUNT_OF_THREADS));
        }

        threads.add(startIncrementorThread((incrementTo / AMOUNT_OF_THREADS) + (incrementTo % AMOUNT_OF_THREADS)));

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Thread startIncrementorThread(int incrementTo) {
        return new Thread(() -> {
            for (int i = 0; i < incrementTo; i++) {
                count.incrementAndGet();
            }
        });

    }

    public int getCount() {
        return count.intValue();
    }
}
