package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task3 {
    private Task3() {
    }

    // TODO: почему у меня вот здесь варнинг? Class 'Animal.Type' is exposed outside its defined visibility scope
    // мне не очень это нравится
    public static Map<Animal.Type, Integer> countAnimalsOfTypes(List<Animal> animals) {
        // TODO: вот тут хочу еще сделать, чтобы для типов, которых
        //  нет в листе, в мапе хранился 0. Пока не придумал как.
        // list.forEach(e->map.putIfAbsent(e.getDepartment(), Collections.emptyList()));
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(e -> 1)));
    }
}
