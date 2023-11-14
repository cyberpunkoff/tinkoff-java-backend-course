package edu.hw5.task3.dateparsers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateProcessorType3 extends DateParserProcessor {
    public DateProcessorType3(DateParserProcessor next) {
        super(next);
    }

    @Override
    public LocalDate parse(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

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
