package edu.project2.solvers;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BreadthFirstMazeSolverTest {
    @Test
    void testSolveMaze() {
        Maze maze = new Maze(5, 5);
        MazeSolver mazeSolver = new BreadthFirstMazeSolver();

        maze.getCell(1, 1).setDestroyed(true);
        maze.getCell(2, 1).setDestroyed(true);
        maze.getCell(3, 1).setDestroyed(true);
        maze.getCell(3, 2).setDestroyed(true);
        maze.getCell(3, 3).setDestroyed(true);

        List<Cell> path = List.of(
            maze.getCell(1, 1),
            maze.getCell(2, 1),
            maze.getCell(3, 1),
            maze.getCell(3, 2),
            maze.getCell(3, 3)
        );

        mazeSolver.solveMaze(maze);
        path.forEach(cell -> assertThat(maze.isInSolution(cell)).isTrue());
    }
}
