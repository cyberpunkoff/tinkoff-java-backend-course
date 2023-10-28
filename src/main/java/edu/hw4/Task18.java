package edu.hw4;

import java.util.Comparator;
import java.util.List;

public final class Task18 {
    private Task18() {
    }

    public static Animal findHeaviestFishInListOfLists(List<List<Animal>> animals) {
        return animals.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::height)).orElseThrow();
    }
}
