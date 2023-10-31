package edu.project2.output;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;

public class ConsoleMazePrinter implements MazePrinter {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static final Character WALL_SYMBOL = '█';
    private static final Character EMPTY_SYMBOL = ' ';

    @Override
    @SuppressWarnings("RegexpSinglelineJava")
    public void printMaze(Maze maze) {
        int mazeWidth = maze.getWidth();
        int mazeHeight = maze.getHeight();

        for (int j = 0; j < mazeHeight; j++) {
            for (int i = 0; i < mazeWidth; i++) {
                Cell tempCell = maze.getCell(i, j);

                if (!tempCell.isDestroyed()) {
                    System.out.print(ANSI_BLACK + WALL_SYMBOL + ANSI_BLACK);
                } else {
                    if (maze.isInSolution(tempCell)) {
                        System.out.print(ANSI_GREEN + WALL_SYMBOL + ANSI_GREEN);
                    } else {
                        System.out.print(ANSI_WHITE + WALL_SYMBOL + ANSI_WHITE);

                    }
                }
            }

            System.out.println();
        }
    }
}
