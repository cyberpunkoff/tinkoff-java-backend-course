package edu.hw5.task3.dateparsers;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateProcessorType9 extends DateParserProcessor {
    public DateProcessorType9(DateParserProcessor next) {
        super(next);
    }

    @Override
    public LocalDate parse(String input) {
        Pattern pattern = Pattern.compile("^([1-9]\\d+) days ago$");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            int daysAgo = Integer.parseInt(matcher.group(1));
            return LocalDate.now().minusDays(daysAgo);
        } else if (nextProcessor != null) {
            return nextProcessor.parse(input);
        } else {
            return null;
        }
    }
}
