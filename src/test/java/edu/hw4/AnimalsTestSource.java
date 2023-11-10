package edu.hw4;

import java.util.List;

public final class AnimalsTestSource {
    /* TODO: возможно это вообще неправильаня логика тестирования, но мне лень было в каждом классе создавать заново List */
    private static final List<Animal> animals;

    static {
        Animal myCat = new Animal("Barsik", Animal.Type.CAT, Animal.Sex.M, 5, 30, 20, false);
        Animal myDog = new Animal("Gjuchka", Animal.Type.DOG, Animal.Sex.F, 2, 37, 13, true);
        Animal myParrot = new Animal("Vasya", Animal.Type.BIRD, Animal.Sex.M, 4, 10, 1, false);
        Animal myParrot2 = new Animal("Kesha", Animal.Type.BIRD, Animal.Sex.M, 4, 10, 1, false);

        animals = List.of(myDog, myCat, myParrot, myParrot2);
    }

    private AnimalsTestSource() {
    }

    public static List<Animal> getAnimals() {
        return animals;
    }
}
