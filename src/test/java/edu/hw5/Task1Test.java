package edu.hw5;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    static Stream<Arguments> averageSessionDurationTestParameters() {
        return Stream.of(
            Arguments.of(
                List.of("2022-03-12, 20:20 - 2022-03-12, 23:50", "2022-04-01, 21:30 - 2022-04-02, 01:20"),
                Duration.ofSeconds(13200)
            ),
            Arguments.of(
                List.of("2022-05-01, 20:20 - 2022-05-02, 00:20", "2022-04-01, 17:30 - 2022-04-01, 23:30"),
                Duration.ofHours(5)
            )
        );
    }

    static Stream<Arguments> prettyPrintDurationTestParameters() {
        return Stream.of(
            Arguments.of(
                Duration.ofSeconds(13200),
                "3ч 40м"
            ),
            Arguments.of(
                Duration.ofMinutes(1500),
                "25ч 0м"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("averageSessionDurationTestParameters")
    void getAverageSessionDurationTest(List<String> input, Duration expected) {
        Duration averageSessionDuration = Task1.getAverageSessionDuration(input);

        assertThat(averageSessionDuration).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("prettyPrintDurationTestParameters")
    void prettyPrintDurationTest(Duration duration, String expected) {
        String result = Task1.prettyPrintDuration(duration);

        assertThat(result).isEqualTo(expected);
    }

}
