package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalsTestSource.getAnimals;
import static org.assertj.core.api.Assertions.assertThat;

public class Task10Test {
    @Test
    void testGetAnimalsWhoseAgeNotEqualsNumberOfPaws_shouldReturnAnimalsWhoseAgeNotEqualsNumberOfPaws() {
        List<Animal> animals = getAnimals();

        List<Animal> animalsWhoseAgeNotEqualsNumberOfPaws = Task10.getAnimalsWhoseAgeNotEqualsNumberOfPaws(
            animals
        );

        assertThat(animalsWhoseAgeNotEqualsNumberOfPaws).isEqualTo(animals); // все животные из AnimalsTestSource удовлетворяют этому условию
    }
}
