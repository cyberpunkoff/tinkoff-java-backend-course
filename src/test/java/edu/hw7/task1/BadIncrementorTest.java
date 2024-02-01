package edu.hw7.task1;

import edu.hw7.task1.BadIncrementor;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BadIncrementorTest {
    @Test
    void badIncrementorTest_shouldNotReturnCorrectValue() {
        int value = 100_000_000;

        BadIncrementor badIncrementor = new BadIncrementor();
        badIncrementor.incrementTo(value);
        int result = badIncrementor.getCount();

        assertThat(result).isNotEqualTo(value);
    }
}
