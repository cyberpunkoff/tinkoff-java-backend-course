package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    static Stream<Arguments> getAllFridayTheThirteensOfYearTestSource() {
        return Stream.of(
            Arguments.of(
                1925,
                List.of(
                    LocalDate.parse("1925-02-13"),
                    LocalDate.parse("1925-03-13"),
                    LocalDate.parse("1925-11-13")
                )
            ),
            Arguments.of(
                2024,
                List.of(
                    LocalDate.parse("2024-09-13"),
                    LocalDate.parse("2024-12-13")
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("getAllFridayTheThirteensOfYearTestSource")
    void testGetAllFridayTheThirteensOfYear(int year, List<LocalDate> expected) {
        List<LocalDate> fridays = Task2.getAllFridayTheThirteensOfYear(year);

        assertThat(fridays).isEqualTo(expected);
    }

    @Test
    void testGetClosestFridayTheThirteenForDate() {
        LocalDate date = LocalDate.parse("1925-03-10");
        LocalDate closestFriday = LocalDate.parse("1925-03-13");

        LocalDate foundFriday = Task2.getClosestFridayTheThirteenForDate(date);

        assertThat(foundFriday).isEqualTo(closestFriday);
    }
}
