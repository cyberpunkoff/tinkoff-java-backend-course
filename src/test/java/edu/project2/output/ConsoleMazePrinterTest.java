package edu.project2.output;

import edu.project2.MazeTestUtils;
import edu.project2.maze.Maze;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleMazePrinterTest {
    private static final Character WALL_SYMBOL = '█';
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK = "\u001B[30m";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    @DisplayName("Лабиринт, состоящий из стен")
    void printMazeTest_shouldPrintAllWalls() {
        Maze maze = new Maze(10, 10);
        MazePrinter mazePrinter = new ConsoleMazePrinter();
        System.setOut(new PrintStream(outputStreamCaptor));

        String expected = MazeTestUtils.generatePrintString(
            11, 11,
            ANSI_BLACK + WALL_SYMBOL + ANSI_BLACK
        );
        mazePrinter.printMaze(maze);

        assertThat(outputStreamCaptor.toString()).isEqualTo(expected);

        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Лабиринт, состоящий из проходов")
    void printMazeTest_shouldPrintAllPassages() {
        Maze maze = new Maze(10, 10);
        MazePrinter mazePrinter = new ConsoleMazePrinter();
        System.setOut(new PrintStream(outputStreamCaptor));

        String expected = MazeTestUtils.generatePrintString(
            11, 11,
            ANSI_WHITE + WALL_SYMBOL + ANSI_WHITE
        );
        MazeTestUtils.destroyAllWallsInMaze(maze);
        mazePrinter.printMaze(maze);

        assertThat(outputStreamCaptor.toString()).isEqualTo(expected);

        System.setOut(standardOut);
    }
}
