package edu.hw2.inheritance;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class InheritanceTest {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle()),
            Arguments.of(new Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect = rect.setWidth(20);
        rect = rect.setHeight(10);

        assertThat(rect.area()).isEqualTo(200.0);
    }
}
