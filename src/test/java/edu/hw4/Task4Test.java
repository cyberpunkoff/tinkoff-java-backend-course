package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    void testGetAnimalWithLongestName_shouldReturnAnimalWithLongestName() {
        // given
        List<Animal> animals = getAnimals();

        // when
        Animal animalWithLongestName = Task4.getAnimalWithLongestName(animals);

        // then
        assertThat(animalWithLongestName).isEqualTo(
            new Animal("Gjuchka", Animal.Type.DOG, Animal.Sex.F, 2, 37, 13, true)
        );
    }
}
