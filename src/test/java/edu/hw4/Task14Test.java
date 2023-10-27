package edu.hw4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task14Test {
    @ParameterizedTest
    @CsvSource({"30, true", "40, false"})
    void testHasDogWhichHeightMoreThanK_shouldReturnTrueIfHasDogWhichHeightMoreThanK(int k, boolean expected) {
        List<Animal> animals = getAnimals();

        boolean hasDogHigherThanK = Task14.hasDogHigherThanK(animals, k);

        assertThat(hasDogHigherThanK).isEqualTo(expected);

    }
}
