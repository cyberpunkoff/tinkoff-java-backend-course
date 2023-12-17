package edu.hw10.task1;

import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.Random;

public class RandomFieldGenerator {
    private final Random random = new SecureRandom();

    Object generate(Field field) {
        Class<?> type = field.getType();
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        boolean notNull = field.getAnnotation(NotNull.class) != null;

        if (field.getAnnotation(Min.class) != null) {
            min = field.getAnnotation(Min.class).value();
        }

        if (field.getAnnotation(Max.class) != null) {
            max = field.getAnnotation(Max.class).value();
        }

        if (type.equals(int.class) || type.equals(Integer.class)) {
            return random.nextInt(min, max);
        } else if (type.equals(double.class) || type.equals(Double.class)) {
            return random.nextDouble(min, max);
        } else if (type.equals(String.class) && notNull) {
            return "test";
        }

        return null;
    }
}
