package edu.hw5.task3.dateparsers;

import java.time.LocalDate;

public class DateProcessorType5 extends DateParserProcessor {
    public DateProcessorType5(DateParserProcessor next) {
        super(next);
    }

    @Override
    public LocalDate parse(String input) {
        if (input.equals("tomorrow")) {
            return LocalDate.now().plusDays(1);
        } else if (nextProcessor != null) {
            return nextProcessor.parse(input);
        } else {
            return null;
        }
    }
}
