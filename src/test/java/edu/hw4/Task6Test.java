package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    void testGetOldestAnimalsOfTypes_shouldReturnListOldestAnimalsOfTypes() {
        List<Animal> animals = getAnimals();

        Map<Animal.Type, Animal> oldestAnimals = Task6.getOldestAnimalsOfTypes(animals);

        assertThat(oldestAnimals).contains(
            Map.entry(Animal.Type.BIRD, new Animal("Vasya", Animal.Type.BIRD, Animal.Sex.M, 4, 10, 1, false)),
            Map.entry(Animal.Type.CAT, new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 5, 30, 20, false)),
            Map.entry(Animal.Type.DOG, new Animal("Gjuchka", Animal.Type.DOG, Animal.Sex.F, 2, 37, 13, true))
        );
    }
}
