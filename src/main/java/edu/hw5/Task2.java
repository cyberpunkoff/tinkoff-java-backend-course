package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public final class Task2 {
    private static final int THIRTEEN = 13;

    private Task2() {
    }

    public static List<LocalDate> getAllFridayTheThirteensOfYear(int year) {
        List<LocalDate> fridays = new ArrayList<>();

        for (int i = 1; i <= Month.values().length; i++) {
            LocalDate day = LocalDate.of(year, i, THIRTEEN);
            if (day.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                fridays.add(day);
            }
        }

        return fridays;
    }

    public static LocalDate getClosestFridayTheThirteenForDate(LocalDate date) {
        LocalDate current = date.getDayOfMonth() > THIRTEEN ?
            date.plusMonths(1).withDayOfMonth(THIRTEEN) :
            date.withDayOfMonth(THIRTEEN);

        while (current.getDayOfWeek() != DayOfWeek.FRIDAY) {
            current = current.plusMonths(1);
        }

        return current;
    }
}
