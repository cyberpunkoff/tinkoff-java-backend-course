package edu.hw5.task3.dateparsers;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateProcessorType1 extends DateParserProcessor {
    public DateProcessorType1(DateParserProcessor next) {
        super(next);
    }

    @Override
    public LocalDate parse(String input) {
        try {
            return LocalDate.parse(input);
        } catch (DateTimeParseException e) {
            if (nextProcessor != null) {
                return nextProcessor.parse(input);
            } else {
                return null;
            }
        }
    }
}
