package edu.hw4;

import edu.hw4.validationerrors.IncorrectAgeValidationError;
import edu.hw4.validationerrors.IncorrectHeightValidationError;
import edu.hw4.validationerrors.ValidationError;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class Task19Test {
    @Test
    void testValidateAnimals_shouldReturnAnimalsAndTheirErrors() {
        List<Animal> animals = List.of(
            new Animal("Invalid bird", Animal.Type.BIRD, Animal.Sex.F, -10, -1, 1, false),
            new Animal("Invalid dog", Animal.Type.DOG, Animal.Sex.F, -2, 5, 1, false),
            new Animal("Valid cat", Animal.Type.CAT, Animal.Sex.F, 3, 5, 1, false)
        );

        Map<String, Set<ValidationError>> errors = Task19.validateAnimals(animals);

        assertThat(errors).contains(
            Map.entry(
                "Invalid bird", Set.of(
                    IncorrectAgeValidationError.INCORRECT_AGE_VALIDATION_ERROR,
                    IncorrectHeightValidationError.INCORRECT_HEIGHT_VALIDATION_ERROR
                )
            ),
            Map.entry("Invalid dog", Set.of(IncorrectAgeValidationError.INCORRECT_AGE_VALIDATION_ERROR))
        );

    }
}
