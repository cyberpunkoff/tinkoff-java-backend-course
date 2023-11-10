package edu.hw4;

import java.util.List;

public final class Task17 {
    private Task17() {
    }

    public static boolean doSpidersBiteMoreThanDogs(List<Animal> animals) {
        // в один стрим наверное можно запихнуть...
        // Но там такая каша будет мне кажется. А тут довольно читаемо получилось
        long bitingSpidersCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites())
            .count();

        long bitingDogsCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG && animal.bites())
            .count();

        // не понял про "недостаточно данных для ответа", поэтому, когда нет ни тех, ни тех возвращаем false

        return bitingDogsCount < bitingSpidersCount;
    }
}
