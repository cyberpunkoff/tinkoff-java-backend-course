package edu.hw7.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MonteCarloPiMultithread {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int NANOSECONDS_TO_MILLISECONDS = 1_000_000;
    private static final int RADIUS = 1;
    private static final int AMOUNT_OF_THREADS = 8;
    private int totalCount;
    private int circleCount;
    CountDownLatch latch = new CountDownLatch(AMOUNT_OF_THREADS);
    ExecutorService executor = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);

    @SuppressWarnings("MagicNumber")
    public double calculatePi(int iterations) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < AMOUNT_OF_THREADS; i++) {
            threads.add(new Thread(startThread(iterations / AMOUNT_OF_THREADS)));
        }

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        return (double) 4 * circleCount / totalCount;
    }

    private Runnable startThread(int iterations) {
        return () -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();

            int localCircleCount = 0;
            int localTotalCount = 0;

            for (int i = 0; i < iterations; i++) {
                double pointX = random.nextDouble() * RADIUS;
                double pointY = random.nextDouble() * RADIUS;

                    if (pointX * pointX + pointY * pointY < RADIUS * RADIUS) {
                        localCircleCount++;
                    }

                    localTotalCount++;
            }

            totalCount = localTotalCount;
            circleCount = localCircleCount;
        };
    }

    @SuppressWarnings("MagicNumber")
    public void calculatePiWithStats(int iterations) {
        LOGGER.info("Calculating PI with " + AMOUNT_OF_THREADS + " threads and " + iterations + " iterations");
        long start = System.nanoTime();
        double result = new MonteCarloPiMultithread().calculatePi(iterations);
        long finish = System.nanoTime();
        LOGGER.info("PI = " + result);
        LOGGER.info("Calculation took " + (finish - start) / NANOSECONDS_TO_MILLISECONDS + "ms");
        LOGGER.info(String.format("mistake %.3f %%", Math.abs(Math.PI - result) / Math.PI * 100));
        LOGGER.info("---------------------");
    }
}
