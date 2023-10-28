package edu.hw4.validationerrors;

import edu.hw4.Animal;

public abstract class ValidationError {
    //public static final List<ValidationError> VALIDATION_ERRORS = List.of();
    // хотел вобще тут хранить ошибки изначально
    // но что-то не срослось, потому что там какой-то deadlock

    private final String rule;

    ValidationError(String rule) {
        this.rule = rule;
    }

    public abstract boolean isValid(Animal animal);

    @Override public String toString() {
        return rule;
    }
}


