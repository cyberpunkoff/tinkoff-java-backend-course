package edu.hw4;

import edu.hw4.validationerrors.EmptyNameValidationError;
import edu.hw4.validationerrors.IncorrectAgeValidationError;
import edu.hw4.validationerrors.IncorrectHeightValidationError;
import edu.hw4.validationerrors.ValidationError;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Task19 {
    public static final List<ValidationError> VALIDATION_ERRORS = List.of(
        EmptyNameValidationError.EMPTY_NAME_VALIDATION_ERROR,
        IncorrectAgeValidationError.INCORRECT_AGE_VALIDATION_ERROR,
        IncorrectHeightValidationError.INCORRECT_HEIGHT_VALIDATION_ERROR
    );

    private Task19() {
    }

    public static Map<String, Set<ValidationError>> validateAnimals(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(Animal::name, Task19::validateAnimal))
            .entrySet()
            .stream()
            .filter(entry -> !entry.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Set<ValidationError> validateAnimal(Animal animal) {
        return VALIDATION_ERRORS.stream()
            .filter(error -> !error.isValid(animal))
            .collect(Collectors.toSet());
    }
}
