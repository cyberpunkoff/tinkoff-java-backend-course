package edu.hw3;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class FrequencyCounterTest {
    static Stream<Arguments> counterParameters() {
        return Stream.of(
            Arguments.of(
                List.of("a", "bb", "a", "bb"),
                Map.ofEntries(Map.entry("bb", 2), Map.entry("a", 2))
            ),
            Arguments.of(
                List.of("this", "and", "that", "and"),
                Map.ofEntries(Map.entry("that", 1), Map.entry("and", 2), Map.entry("this", 1))
            )
        );
    }

    @ParameterizedTest
    @MethodSource("counterParameters")
    <K> void testCounter(List<K> input, Map<K, Integer> expected) {
        Map<K, Integer> result = FrequencyCounter.generateFrequencyDict(input);

        assertThat(result).isEqualTo(expected);
    }
}
