package edu.hw4;

import java.util.List;

public final class Task11 {
    private Task11() {
    }

    public static List<Animal> getDangerousAnimals(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > 100)
            .toList();
    }
}
