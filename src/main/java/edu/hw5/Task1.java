package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class Task1 {
    public static final int MINUTES_IN_HOUR = 60;

    private Task1() {
    }

    public static Duration getAverageSessionDuration(List<String> sessions) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

        return sessions.stream()
            .map(session -> session.split(" - "))
            .map(session -> new LocalDateTime[] {
                LocalDateTime.parse(session[0], dateTimeFormatter),
                LocalDateTime.parse(session[1], dateTimeFormatter)}
            )
            .map(session -> Duration.between(session[0], session[1]))
            .reduce(Duration.ZERO, Duration::plus)
            .dividedBy(sessions.size());
    }

    // не уверен, что этот метод вообще нужен по заданию, как обычно довольно расплывчатая формулировка о том,
    // что должен вернуть метод. но на всякий случай я сделал
    public static String prettyPrintDuration(Duration duration) {
        var minutes = duration.toMinutes();
        return String.format("%dч %dм", minutes / MINUTES_IN_HOUR, minutes % MINUTES_IN_HOUR);
    }
}
