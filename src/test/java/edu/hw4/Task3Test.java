package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    void countAnimalsOfTypes_shouldReturnAmountOfAnimals() {
        List<Animal> animals = getAnimals();

        Map<Animal.Type, Integer> animalsCount = Task3.countAnimalsOfTypes(animals);

        assertThat(animalsCount).containsExactly(
            Map.entry(Animal.Type.CAT, 1),
            Map.entry(Animal.Type.DOG, 1),
            Map.entry(Animal.Type.BIRD, 2)
        );
    }
}
