package edu.hw3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FrequencyCounter {
    private FrequencyCounter() {
    }

    public static <T> Map<T, Integer> generateFrequencyDict(List<T> inputList) {
        HashMap<T, Integer> result = new HashMap<>();

        inputList.forEach(e -> result.merge(e, 1, Integer::sum));

        return result;
    }
}
