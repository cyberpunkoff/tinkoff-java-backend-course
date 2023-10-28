package edu.hw4;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task18Test {
    @Test
    void testFindHeaviestFishInListOfLists() {
        List<List<Animal>> animals = List.of(
            List.of(new Animal("TestBird", Animal.Type.BIRD, Animal.Sex.M, 10, 10, 10, false)),
            List.of(new Animal("TestFish", Animal.Type.FISH, Animal.Sex.M, 10, 10, 10, false))
        );

        Animal fish = Task18.findHeaviestFishInListOfLists(animals);

        assertThat(fish).isEqualTo(
            new Animal("TestFish", Animal.Type.FISH, Animal.Sex.M, 10, 10, 10, false)
        );
    }
}
