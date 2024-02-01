package edu.hw7.task4;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MonteCarloPi {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int NANOSECONDS_TO_MILLISECONDS = 1_000_000;

    private static final int RADIUS = 1;

    private double totalCount;
    private double circleCount;


    @SuppressWarnings("MagicNumber")
    public double monteCarloCalc(int iterations) {
        Random random = new Random();

        for (int i = 0; i < iterations; i++) {
            double pointX = random.nextDouble() * RADIUS * (random.nextBoolean() ? 1 : -1);
            double pointY = random.nextDouble() * RADIUS * (random.nextBoolean() ? 1 : -1);

            if (pointX * pointX + pointY * pointY < RADIUS * RADIUS) {
                circleCount++;
            }

            totalCount++;
        }

       return 4 * (circleCount / totalCount);
    }

    @SuppressWarnings("MagicNumber")
    public void monteCarloWithStats(int iterations) {
        LOGGER.info("Calculating PI in single thread and " + iterations + " iterations");
        long start = System.nanoTime();
        double result = new MonteCarloPi().monteCarloCalc(iterations);
        long finish = System.nanoTime();
        LOGGER.info("PI = " + result);
        LOGGER.info("Calculation took " + (finish - start) / NANOSECONDS_TO_MILLISECONDS + "ms");
        LOGGER.info(String.format("mistake %.3f %%", Math.abs(Math.PI - result) / Math.PI * 100));
        LOGGER.info("---------------------");
    }
}
