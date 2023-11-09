package edu.hw4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class Task18 {
    private Task18() {
    }

    public static Animal findHeaviestFishInListOfLists(List<Animal>... animals) {
        return Arrays.stream(animals)
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight)).orElseThrow();
    }
}
