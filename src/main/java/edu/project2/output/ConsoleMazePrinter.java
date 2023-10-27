package edu.project2.output;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;

public class ConsoleMazePrinter implements MazePrinter {
    private static final Character WALL_SYMBOL = 'X';
    private static final Character EMPTY_SYMBOL = ' ';

    @Override
    public void printMaze(Maze maze) {
        int mazeWidth = maze.getWidth();
        int mazeHeight = maze.getHeight();

        for (int j = 0; j < mazeHeight; j++) {
            for (int i = 0; i < mazeWidth; i++) {
                Cell tempCell = new Cell(i, j);

                if (maze.isWall(tempCell)) {
                    System.out.print(WALL_SYMBOL);
                } else {
                    System.out.print(EMPTY_SYMBOL);
                }
            }

            System.out.println();
        }
    }
}
