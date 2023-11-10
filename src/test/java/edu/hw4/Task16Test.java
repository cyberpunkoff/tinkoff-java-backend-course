package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task16Test {
    @Test
    void testSortAnimalsByTypeThenBySexThenByName_shouldReturnSortedAnimalsList() {
        List<Animal> animals = getAnimals();

        List<Animal> sortedAnimals = Task16.sortAnimalsByTypeThenBySexThenByName(animals);

        assertThat(sortedAnimals).containsExactly(
            new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 5, 30, 20, false),
            new Animal("Gjuchka", Animal.Type.DOG, Animal.Sex.F, 2, 37, 13, true),
            new Animal("Kesha", Animal.Type.BIRD, Animal.Sex.M, 4, 10, 1, false),
            new Animal("Vasya", Animal.Type.BIRD, Animal.Sex.M, 4, 10, 1, false)
        );
    }
}
