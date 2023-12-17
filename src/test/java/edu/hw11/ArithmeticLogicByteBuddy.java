package edu.hw11;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ArithmeticLogicByteBuddy {
    @Test
    void sumToMulTest() throws Exception {
        Class<?> dynamicType = new ByteBuddy()
            .subclass(ArithmeticUtils.class)
            .method(ElementMatchers.named("sum"))
            .intercept(MethodDelegation.to(getClass()))
            .make()
            .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
            .getLoaded();

        ArithmeticUtils modifiedInstance = (ArithmeticUtils) dynamicType.getDeclaredConstructor().newInstance();

        int result = modifiedInstance.sum(5, 7);

        assertThat(result).isEqualTo(35);
    }

    public static int sum(int a, int b) {
        return a * b;
    }
}
