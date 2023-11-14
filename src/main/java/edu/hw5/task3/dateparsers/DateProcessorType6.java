package edu.hw5.task3.dateparsers;

import java.time.LocalDate;

public class DateProcessorType6 extends DateParserProcessor {
    public DateProcessorType6(DateParserProcessor next) {
        super(next);
    }

    @Override
    public LocalDate parse(String input) {
        if (input.equals("today")) {
            return LocalDate.now();
        } else if (nextProcessor != null) {
            return nextProcessor.parse(input);
        } else {
            return null;
        }
    }
}
