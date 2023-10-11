package edu.hw1;

import java.util.Objects;

public final class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String duration) {
        Objects.requireNonNull(duration);

        String[] splitDuration = duration.split(":");

        if (splitDuration.length != 2) {
            return -1;
        }

        int seconds;
        int minutes;

        try {
            minutes = Integer.parseInt(splitDuration[0]);
            seconds = Integer.parseInt(splitDuration[1]);
        } catch (NumberFormatException e) {
            return -1;
        }

        if (seconds >= SECONDS_IN_MINUTE) {
            return -1;
        }

        return seconds + minutes * SECONDS_IN_MINUTE;
    }
}
