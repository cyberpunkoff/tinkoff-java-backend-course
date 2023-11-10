package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    @Test
    void testGetHeaviestAnimalWhichHeightLessThanK_shouldReturnHeaviestAnimalWhichHeightLessThanK() {
        List<Animal> animals = getAnimals();

        Optional<Animal> heaviestAnimal = Task8.getHeaviestAnimalWhichHeightLessThanK(animals, 35);

        assertThat(heaviestAnimal).contains(
            new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 5, 30, 20, false)
        );
    }
}
