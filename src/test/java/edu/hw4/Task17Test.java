package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task17Test {
    @Test
    void testDoSpidersBiteMoreThanDogs_shouldReturnTrueIfSpidersBiteMoreThanDogs() {
        List<Animal> animals = getAnimals();

        boolean doSpidersBiteMoreThanDogs = Task17.doSpidersBiteMoreThanDogs(animals);

        assertThat(doSpidersBiteMoreThanDogs).isFalse();
    }
}
