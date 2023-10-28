package edu.hw4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

public class Task20Test {
    private static final Logger LOGGER = LogManager.getLogger();
    @Test
    void testGetPrettyValidationResults_shouldReturnPrettyResults() {
        List<Animal> animals = List.of(
            new Animal("Invalid bird", Animal.Type.BIRD, Animal.Sex.F, -10, -1, 1, false),
            new Animal("Invalid dog", Animal.Type.DOG, Animal.Sex.F, -2, 5, 1, false),
            new Animal("Valid cat", Animal.Type.CAT, Animal.Sex.F, 3, 5, 1, false)
        );

        Map<String, String> errorsList = Task20.getPrettyValidationResults(animals);

        // тут в качестве проверки вывод
        LOGGER.info(errorsList);
    }
}
