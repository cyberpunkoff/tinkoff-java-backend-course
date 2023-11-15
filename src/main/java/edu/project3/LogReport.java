package edu.project3;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

public class LogReport {
    private Map<Integer, Integer> responseCodesCount;
    private Map<String, Integer> requestedResourceCount;
    private ZonedDateTime fromDate;
    private ZonedDateTime toDate;
    private List<String> paths;
    private int requestCount;
    private long averageBodyBytesSent;


    public LogReport(List<LogRecord> logRecords, List<String> paths, ZonedDateTime fromDate, ZonedDateTime toDate) {
        if (fromDate == null) {
            this.fromDate = ZonedDateTime.from(LocalDateTime.MIN);
        }
        if (toDate == null) {
            this.toDate = ZonedDateTime.from(LocalDateTime.MAX);
        }

        this.paths = paths;

        logRecords.stream()
            .filter(logRecord -> logRecord.getTimeLocal().isAfter(fromDate) && logRecord.getTimeLocal().isBefore(toDate))
            .forEach(logRecord -> {
                responseCodesCount.merge(logRecord.getStatus(), 1, Integer::sum);
                requestedResourceCount.merge(logRecord.getRequest().getResource(), 1, Integer::sum);
                averageBodyBytesSent += logRecord.getBodyBytesSent();
                requestCount++;
            });

        averageBodyBytesSent /= requestCount;
    }
}
