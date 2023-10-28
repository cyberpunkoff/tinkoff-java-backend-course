package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task20 {
    private Task20() {
    }

    public static Map<String, String> getPrettyValidationResults(List<Animal> animals) {
        return Task19.validateAnimals(animals).entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().toString()));
    }
}
