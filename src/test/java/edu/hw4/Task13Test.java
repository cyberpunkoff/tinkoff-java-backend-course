package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task13Test {
    @Test
    void testGetAnimalsWhoseNameHasMoreThanTwoWords_shouldReturnAnimalsWithLongNames() {
        List<Animal> animals = getAnimals();

        List<Animal> animalsWithLongNames = Task13.getAnimalsWhoseNameHasMoreThanTwoWords(animals);

        assertThat(animalsWithLongNames).isEmpty();
    }
}
