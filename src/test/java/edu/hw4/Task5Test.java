package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    void testGetPrevailingSex_shouldReturnAnimalWithMostPopularSex() {
        List<Animal> animals = getAnimals();

        Animal.Sex prevailingSex = Task5.getPrevailingSex(animals);

        assertThat(prevailingSex).isEqualTo(Animal.Sex.M);
    }
}
