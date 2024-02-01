package edu.hw11.task3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciTest {
    @Test
    void testFibonacciCorrect() throws Exception {
        Class<?> dynamicType = new ByteBuddy()
            .subclass(Object.class)
            .visit(new EnableFramesComputing())
            .name("Fibonacci")
            .defineMethod("fib", long.class, Modifier.PUBLIC + Modifier.STATIC)
            .withParameter(int.class, "n")
            .intercept(new FibonacciMethod())
            .make()
            .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
            .getLoaded();

        Method method = dynamicType.getDeclaredMethod("fib", int.class);

        assertThat(method.invoke(getClass(), 0)).isEqualTo(1L);
        assertThat(method.invoke(getClass(), 1)).isEqualTo(1L);
        assertThat(method.invoke(getClass(), 10)).isEqualTo(89L);
    }
}
