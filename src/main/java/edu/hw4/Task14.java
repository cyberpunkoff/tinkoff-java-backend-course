package edu.hw4;

import java.util.List;

public final class Task14 {
    private Task14() {
    }

    public static boolean hasDogHigherThanK(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }
}
