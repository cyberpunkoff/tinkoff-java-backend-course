package edu.hw4.validationerrors;

import edu.hw4.Animal;

public final class EmptyNameValidationError extends ValidationError {
    public static final EmptyNameValidationError EMPTY_NAME_VALIDATION_ERROR = new EmptyNameValidationError();

    private EmptyNameValidationError() {
        super("Имя животного не должно быть пустым");
    }

    @Override
    public boolean isValid(Animal animal) {
        return !(animal.name() == null || animal.name().isEmpty() || animal.name().isBlank());
    }
}
