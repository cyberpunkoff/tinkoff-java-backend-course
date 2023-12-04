package edu.project2.maze;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MazeTest {
    @Test
    void testIsValidCell_invalidCellShouldReturnFalse() {
        Maze maze = new Maze(10, 10);

        boolean result = maze.isValidCell(-1, -1);

        assertThat(result).isFalse();
    }

    @Test
    void testIsValidCell_correctCellShouldReturnTrue() {
        Maze maze = new Maze(10, 10);

        boolean result = maze.isValidCell(2, 2);

        assertThat(result).isTrue();
    }
}
