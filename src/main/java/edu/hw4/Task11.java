package edu.hw4;

import java.util.List;

public final class Task11 {
    private static final int DANGEROUS_ANIMAL_HEIGHT = 100;

    private Task11() {
    }

    public static List<Animal> getDangerousAnimals(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > DANGEROUS_ANIMAL_HEIGHT)
            .toList();
    }
}
