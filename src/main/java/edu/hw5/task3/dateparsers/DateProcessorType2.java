package edu.hw5.task3.dateparsers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateProcessorType2 extends DateParserProcessor {
    public DateProcessorType2(DateParserProcessor next) {
        super(next);
    }

    @Override
    public LocalDate parse(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

        try {
            return LocalDate.parse(input, formatter);
        } catch (DateTimeParseException e) {
            if (nextProcessor != null) {
                return nextProcessor.parse(input);
            } else {
                return null;
            }
        }
    }
}
