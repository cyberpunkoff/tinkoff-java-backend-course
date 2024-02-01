package edu.hw10.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RandomObjectGenerator {
    private RandomFieldGenerator randomFieldGenerator = new RandomFieldGenerator();
    private final static Logger LOGGER = LogManager.getLogger();


    public <T> T nextObject(Class<T> clazz) {
        return nextObject(clazz, null);
    }

    public <T> T nextObject(Class<T> clazz, String methodName) {
        T instance = null;
        try {
            if (clazz.isRecord()) {
                Class<?>[] fieldTypes =
                    Arrays.stream(clazz.getRecordComponents())
                        .map(RecordComponent::getType)
                        .toArray(Class<?>[]::new);

                Object[] params = Arrays.stream(clazz.getDeclaredFields())
                    .map(randomFieldGenerator::generate)
                    .toArray();

                instance = clazz.getDeclaredConstructor(fieldTypes).newInstance(params);
            } else {
                Constructor<T> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);

                if (methodName != null && !methodName.isEmpty()) {
                    instance = (T) clazz.getDeclaredMethod(methodName).invoke(null);
                } else {
                    instance = constructor.newInstance();
                }

                for (Field field : clazz.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Min.class) || field.isAnnotationPresent(Max.class)
                        || field.isAnnotationPresent(NotNull.class)) {
                        field.setAccessible(true);

                        field.set(instance, randomFieldGenerator.generate(field));
                    }
                }

            }
        } catch (Exception ex) {
            LOGGER.info("Problems!");
        }

        return instance;
    }

}
