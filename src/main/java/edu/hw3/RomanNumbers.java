package edu.hw3;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

public class RomanNumbers {
    private final static Map<Integer, String> INTEGER_TO_ROMAN = Map.ofEntries(
        entry(1, "I"),
        entry(4, "IV"),
        entry(5, "V"),
        entry(9, "IX"),
        entry(10, "X"),
        entry(40, "XL"),
        entry(50, "L"),
        entry(90, "XC"),
        entry(100, "C"),
        entry(400, "CD"),
        entry(500, "D"),
        entry(900, "CM"),
        entry(1000, "M")
    );

    // TODO: нормальное ли здесь форматирование? почему то мне казалось, что начиная со stream должны быть левее строчки
    // но идея так форматирует
    private final static List<Integer> KEYS = INTEGER_TO_ROMAN.keySet()
        .stream()
        .sorted(Collections.reverseOrder())
        .toList();

    public static String convertToRoman(int number) {
        int tempNumber = number;
        StringBuilder answer = new StringBuilder();
        Iterator<Integer> iterator = KEYS.iterator();

        while (tempNumber > 0) {
            int temp = iterator.next();
            if (tempNumber >= temp) {
                answer.append(INTEGER_TO_ROMAN.get(temp).repeat(tempNumber / temp));
                tempNumber %= temp;
            }
        }

        return answer.toString();
    }
}
