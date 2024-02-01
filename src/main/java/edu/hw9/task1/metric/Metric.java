package edu.hw9.task1.metric;

public interface Metric<T extends  Number> {
    String getName();

    double calculate(T[] numbers);
}
