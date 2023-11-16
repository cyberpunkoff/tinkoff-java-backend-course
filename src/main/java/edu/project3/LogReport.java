package edu.project3;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LogReport {
    private Map<Integer, Integer> responseCodesCount;
    private Map<String, Integer> requestedResourceCount;
    private final LocalDate fromDate;
    private final LocalDate toDate;
    private final List<String> paths;
    private int requestCount;
    private long averageBodyBytesSent;

    public LogReport(List<LogRecord> logRecords, LocalDate fromDate, LocalDate toDate, List<String> paths) {
        responseCodesCount = new TreeMap<>();
        requestedResourceCount = new HashMap<>();
        this.paths = paths;

        // from and to dates inclusive
        // that's why I need to add one day to toDate
        this.fromDate = Objects.requireNonNullElse(fromDate, LocalDate.MIN);
        if (toDate != null) {
            this.toDate = toDate.plusDays(1);
        } else {
            this.toDate = LocalDate.MAX;
        }

        logRecords.stream()
            .filter(logRecord ->
                !logRecord.getTimeLocal().isBefore(OffsetDateTime.of(this.fromDate.atStartOfDay(), ZoneOffset.UTC))
                    && logRecord.getTimeLocal()
                    .isBefore(OffsetDateTime.of(this.toDate.atStartOfDay(), ZoneOffset.UTC)))
            .forEach(logRecord -> {
                responseCodesCount.merge(logRecord.getStatus(), 1, Integer::sum);
                requestedResourceCount.merge(logRecord.getRequest().getResource(), 1, Integer::sum);
                averageBodyBytesSent += logRecord.getBodyBytesSent();
                requestCount++;
            });

        if (requestCount != 0) {
            averageBodyBytesSent /= requestCount;
        }

        responseCodesCount = responseCodesCount.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        requestedResourceCount = requestedResourceCount.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
