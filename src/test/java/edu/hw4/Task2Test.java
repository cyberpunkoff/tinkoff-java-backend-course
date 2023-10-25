package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    void testGetKHeaviestAnimals_shouldReturnHeaviestAnimal() {
        List<Animal> animals = getAnimals();

        List<Animal> heaviestAnimals = Task2.getKHeaviestAnimals(animals, 1);

        /* TODO: ну да, возможно, не очень понятно, что должен вернуть этот метод, но иначе придется в каждый метод вставлять создание листа */
        assertThat(heaviestAnimals).isEqualTo(List.of(
            new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 5, 30, 20, false)
        ));
    }
}
