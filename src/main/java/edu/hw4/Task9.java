package edu.hw4;

import java.util.List;
import java.util.stream.Collectors;

public final class Task9 {
    private Task9() {
    }

    public static Integer getSumOfPaws(List<Animal> animals) {
        return animals.stream().mapToInt(Animal::paws).sum();
    }
}
