package edu.hw4.validationerrors;

import edu.hw4.Animal;

public final class IncorrectAgeValidationError extends ValidationError {
    public static final IncorrectAgeValidationError INCORRECT_AGE_VALIDATION_ERROR = new IncorrectAgeValidationError();

    private IncorrectAgeValidationError() {
        super("Возраст животного должен быть положительным числом");
    }

    @Override
    public boolean isValid(Animal animal) {
        return animal.age() > 0;
    }
}
