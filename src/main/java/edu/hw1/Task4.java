package edu.hw1;

import java.util.Objects;

public final class Task4 {
    private Task4() {
    }

    public static String fixString(String input) {
        Objects.requireNonNull(input);

        StringBuilder fixedString = new StringBuilder();

        for (int i = 1; i < input.length(); i += 2) {
            fixedString.append(input.charAt(i));
            fixedString.append(input.charAt(i - 1));
        }

        return fixedString.toString();
    }
}
