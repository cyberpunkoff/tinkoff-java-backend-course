package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task9Test {
    @Test
    void testGetSumOfPaws_shouldReturnSumOfPaws() {
        List<Animal> animals = getAnimals();

        Integer sumOfPaws = Task9.getSumOfPaws(animals);

        assertThat(sumOfPaws).isEqualTo(12);
    }
}
