package edu.hw4.validationerrors;

import edu.hw4.Animal;

public final class IncorrectHeightValidationError extends ValidationError {
    public static final IncorrectHeightValidationError INCORRECT_HEIGHT_VALIDATION_ERROR =
        new IncorrectHeightValidationError();

    private IncorrectHeightValidationError() {
        super("Рост животного должен быть положительным числом");
    }

    @Override public boolean isValid(Animal animal) {
        return animal.height() > 0;
    }
}
