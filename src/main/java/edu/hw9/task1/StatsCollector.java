package edu.hw9.task1;

import edu.hw9.task1.metric.AverageMetric;
import edu.hw9.task1.metric.MaxMetric;
import edu.hw9.task1.metric.Metric;
import edu.hw9.task1.metric.MinMetric;
import edu.hw9.task1.metric.SumMetric;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class StatsCollector {
    public static int THREAD_AMOUNT = 4;
    Map<String, CompletableFuture<String>> stats = new ConcurrentHashMap<>();
    List<Metric<Number>> metrics = List.of(
        new AverageMetric<>(),
        new SumMetric<>(),
        new MaxMetric<>(),
        new MinMetric<>()
    );
    private final ExecutorService threadPool;

    public StatsCollector() {
        threadPool = Executors.newFixedThreadPool(THREAD_AMOUNT);
    }

    <T extends Number> void push(String metricName, T[] numbers) {
        var task = metrics.stream()
            .map(
                metric -> CompletableFuture.supplyAsync(
                    () -> metric.getName() + " - " + metric.calculate(numbers),
                    threadPool
                )).toArray(CompletableFuture[]::new);
        var result = CompletableFuture.allOf(task)
            .thenApply((ignored) ->
                 Arrays.stream(task).map((e) -> {
                    try {
                        return e.get().toString();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }).collect(Collectors.joining(", "))
            );

        stats.put(metricName, result);
    }

    Map<String, String> getStats() {
        CompletableFuture.allOf(stats.values().toArray(CompletableFuture[]::new)).join();

        return stats.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, value -> {
            try {
                return value.getValue().get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }));
    }
}
