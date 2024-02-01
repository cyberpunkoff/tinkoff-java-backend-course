package edu.hw7.task1;

import edu.hw7.task1.RaceIncrementor;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceIncrementorTest {
    @Test
    void raceIncrementorTest_shouldReturnCorrectValue() {
        int value = 100_000_000;

        RaceIncrementor raceIncrementor = new RaceIncrementor();
        raceIncrementor.incrementTo(value);
        int result = raceIncrementor.getCount();

        assertThat(result).isEqualTo(value);
    }
}
