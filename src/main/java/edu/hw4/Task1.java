package edu.hw4;

import java.util.Comparator;
import java.util.List;

public final class Task1 {
    private Task1() {
    }

    public static List<Animal> getSortedByHeightAnimals(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparingInt(Animal::height)).toList();
    }
}
