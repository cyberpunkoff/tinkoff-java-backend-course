package edu.hw5.task3.dateparsers;

import java.time.LocalDate;

public class DateProcessorType8 extends DateParserProcessor {
    public DateProcessorType8(DateParserProcessor next) {
        super(next);
    }

    @Override
    public LocalDate parse(String input) {

        if (input.equals("1 day ago")) {
            return LocalDate.now().minusDays(1);
        } else if (nextProcessor != null) {
            return nextProcessor.parse(input);
        } else {
            return null;
        }
    }
}
