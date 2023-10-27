package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task15Test {
    @Test
    void testGetTotalWeightForTypesOfAnimalsWhoseAgeMoreThanKAndLessThanL_shouldReturnTotalWeightForAnimalTypes() {
        List<Animal> animals = getAnimals();

        // TODO: не уверен насчет этого переноса. Выглядит не очень красиво
        Map<Animal.Type, Integer> totalWeightForTypesOfAnimals =
            Task15.getTotalWeightForTypesOfAnimalsWhoseAgeMoreThanKAndLessThanL(animals, 2, 4);

        assertThat(totalWeightForTypesOfAnimals).containsOnly(
            Map.entry(Animal.Type.DOG, 13),
            Map.entry(Animal.Type.BIRD, 2)
        );
    }
}
