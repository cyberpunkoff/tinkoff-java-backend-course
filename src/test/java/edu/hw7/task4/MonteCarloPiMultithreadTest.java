package edu.hw7.task4;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MonteCarloPiMultithreadTest {
    static Stream<Arguments> iterations() {
        return Stream.of(
            Arguments.of(10_000_000),
            Arguments.of(100_000_000),
            Arguments.of(1_000_000_000)
        );
    }

    @ParameterizedTest
    @MethodSource("iterations")
    void testWithDifferentAmountOfIterations(int iterations) {
        MonteCarloPiMultithread piCalculator = new MonteCarloPiMultithread();

        piCalculator.calculatePiWithStats(iterations);
    }
}
