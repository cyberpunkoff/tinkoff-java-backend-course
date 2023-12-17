package edu.hw10;

import edu.hw10.task1.RandomObjectGenerator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomObjectGeneratorTest {
    @Test
    void testGenerateObject() {
        RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();

        Amogus amogus = randomObjectGenerator.nextObject(Amogus.class);
        Car car = randomObjectGenerator.nextObject(Car.class, "build");

        assertThat(amogus.age()).isGreaterThan(5).isLessThan(20);
        assertThat(car.speed).isGreaterThan(200);
    }
}
