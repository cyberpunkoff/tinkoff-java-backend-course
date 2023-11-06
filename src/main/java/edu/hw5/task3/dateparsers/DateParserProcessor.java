package edu.hw5.task3.dateparsers;

import java.time.LocalDate;

public abstract class DateParserProcessor {

    // 2020-10-10
    //2020-12-2
    //1/3/1976
    //1/3/20
    //tomorrow
    //today
    //yesterday
    //1 day ago
    //2234 days ago
    public DateParserProcessor nextProcessor;

    public DateParserProcessor(DateParserProcessor next) {
        nextProcessor = next;
    }

    public abstract LocalDate parse(String input);
}
