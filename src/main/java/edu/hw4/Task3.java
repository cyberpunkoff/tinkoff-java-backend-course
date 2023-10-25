package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;

public final class Task3 {
    private Task3() {
    }

    public static Map<Animal.Type, Integer> countAnimalsOfTypes(List<Animal> animals) {
        // TODO: ��� ��� ���� ��� �������, ����� ��� �����, ������� ��� � �����, � ���� �������� 0. ���� �� �������� ���
        // list.forEach(e->map.putIfAbsent(e.getDepartment(), Collections.emptyList()));
        return animals.stream().collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(e -> 1)));
    }
}
