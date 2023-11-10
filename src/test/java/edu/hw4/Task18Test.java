package edu.hw4;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task18Test {
    @Test
    void testFindHeaviestFishInListOfLists() {
        List<Animal> firstList = List.of(new Animal("TestBird", Animal.Type.BIRD, Animal.Sex.M, 10, 10, 10, false));
        List<Animal> secondList = List.of(new Animal("TestFish", Animal.Type.FISH, Animal.Sex.M, 10, 10, 10, false));

        Animal fish = Task18.findHeaviestFishInListOfLists(firstList, secondList);

        assertThat(fish).isEqualTo(
            new Animal("TestFish", Animal.Type.FISH, Animal.Sex.M, 10, 10, 10, false)
        );
    }
}
