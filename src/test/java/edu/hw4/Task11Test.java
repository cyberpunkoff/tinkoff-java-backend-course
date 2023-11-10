package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task11Test {
    @Test
    void testGetDangerousAnimals_shouldReturnAnimalsWhichBitesAndWhichHeightMoreThan100() {
        List<Animal> animals = getAnimals();

        List<Animal> dangerousAnimals = Task11.getDangerousAnimals(animals);

        assertThat(dangerousAnimals).isEmpty();
    }
}
