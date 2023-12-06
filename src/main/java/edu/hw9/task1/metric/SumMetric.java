package edu.hw9.task1.metric;

import java.util.Arrays;

public class SumMetric<T extends Number> implements Metric<T> {
    @Override
    public String getName() {
        return "sum";
    }

    @Override
    public double calculate(T[] numbers) {
        return Arrays.stream(numbers).mapToDouble(Number::doubleValue).sum();
    }
}
