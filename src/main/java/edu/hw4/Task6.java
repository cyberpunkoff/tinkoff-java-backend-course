package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Task6 {
    private Task6() {
    }

    public static Map<Animal.Type, Animal> getOldestAnimalsOfTypes(List<Animal> animal) {
        return animal.stream()
            .collect(Collectors.toMap(Animal::type, Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::age))));
    }
}
