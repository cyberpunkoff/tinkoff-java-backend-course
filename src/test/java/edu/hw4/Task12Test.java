package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task12Test {
    @Test
    void testCountAnimalsWhichWeightMoreThanHeight_shouldReturnAmountOfAnimalsWhichWeightMoreThanHeight() {
        List<Animal> animals = getAnimals();

        int amount = Task12.countAnimalsWhichWeightMoreThanHeight(animals);

        assertThat(amount).isEqualTo(0);
    }
}
