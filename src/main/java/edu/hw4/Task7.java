package edu.hw4;

import java.util.Comparator;
import java.util.List;

public final class Task7 {
    private Task7() {
    }

    public static Animal getKOldestAnimal(List<Animal> animals, int k) {
        // k in 1-first numeration 1, 2, 3 ...
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed()).skip(k - 1)
            .findAny().orElseThrow();
    }
}
