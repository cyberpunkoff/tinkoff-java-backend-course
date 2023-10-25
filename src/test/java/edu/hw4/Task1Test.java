package edu.hw4;

import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw4.Task1.getSortedByHeightAnimals;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    void testSortedByHeightAnimals_shouldReturnSortedList() {
        List<Animal> animals = getAnimals();

        List<Animal> sortedAnimals = getSortedByHeightAnimals(animals);

        assertThat(sortedAnimals).isSortedAccordingTo(Comparator.comparingInt(Animal::height));
    }
}
