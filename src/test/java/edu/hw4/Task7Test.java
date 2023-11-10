package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    void testGetKOldestAnimal_shouldReturnOldestAnimal() {
        List<Animal> animals = getAnimals();

        Animal oldestAnimal = Task7.getKOldestAnimal(animals, 1);

        assertThat(oldestAnimal).isEqualTo(
            new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 5, 30, 20, false)
        );
    }
}
