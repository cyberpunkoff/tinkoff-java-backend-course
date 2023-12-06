package edu.hw9.task1;

import org.junit.jupiter.api.Test;

public class StatsCollectorTest {
    @Test
    void testStatsCollector() {
        var array = new Double[] {1.0, 6.23, 1.3, 6.0, 2.6, 6.1, 23.3, 6.0, 1.02};

        StatsCollector collector = new StatsCollector();

        collector.push("demo", array);

        for (var stat : collector.getStats().entrySet()) {
            System.out.println(stat.getKey() + " " + stat.getValue());
        }
    }
}
