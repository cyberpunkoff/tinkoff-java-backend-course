package edu.hw5.task3;

import edu.hw5.task3.dateparsers.DateParserProcessor;
import edu.hw5.task3.dateparsers.DateProcessorType1;
import edu.hw5.task3.dateparsers.DateProcessorType2;
import edu.hw5.task3.dateparsers.DateProcessorType3;
import edu.hw5.task3.dateparsers.DateProcessorType4;
import edu.hw5.task3.dateparsers.DateProcessorType5;
import edu.hw5.task3.dateparsers.DateProcessorType6;
import edu.hw5.task3.dateparsers.DateProcessorType7;
import edu.hw5.task3.dateparsers.DateProcessorType8;
import edu.hw5.task3.dateparsers.DateProcessorType9;
import java.time.LocalDate;
import java.util.Optional;

public final class Task3 {
    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String date) {
        DateParserProcessor authParseProcessorChain = getChainOfDateParsersProcessor();

        LocalDate parsed = authParseProcessorChain.parse(date);

        if (parsed != null) {
            return Optional.of(parsed);
        } else {
            return Optional.empty();
        }
    }

    private static DateParserProcessor getChainOfDateParsersProcessor() {
        DateParserProcessor dateParserProcessorType1 = new DateProcessorType1(null);
        DateParserProcessor dateParserProcessorType2 = new DateProcessorType2(dateParserProcessorType1);
        DateParserProcessor dateParserProcessorType3 = new DateProcessorType3(dateParserProcessorType2);
        DateParserProcessor dateParserProcessorType4 = new DateProcessorType4(dateParserProcessorType3);
        DateParserProcessor dateParserProcessorType5 = new DateProcessorType5(dateParserProcessorType4);
        DateParserProcessor dateParserProcessorType6 = new DateProcessorType6(dateParserProcessorType5);
        DateParserProcessor dateParserProcessorType7 = new DateProcessorType7(dateParserProcessorType6);
        DateParserProcessor dateParserProcessorType8 = new DateProcessorType8(dateParserProcessorType7);
        return new DateProcessorType9(dateParserProcessorType8);
    }
}
