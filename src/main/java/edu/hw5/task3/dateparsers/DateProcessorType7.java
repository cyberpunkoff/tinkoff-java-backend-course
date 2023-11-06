package edu.hw5.task3.dateparsers;

import java.time.LocalDate;

public class DateProcessorType7 extends DateParserProcessor {
    public DateProcessorType7(DateParserProcessor next) {
        super(next);
    }

    @Override
    public LocalDate parse(String input) {
        if (input.equals("yesterday")) {
            return LocalDate.now().minusDays(1);
        } else if (nextProcessor != null) {
            return nextProcessor.parse(input);
        } else {
            return null;
        }
    }
}
