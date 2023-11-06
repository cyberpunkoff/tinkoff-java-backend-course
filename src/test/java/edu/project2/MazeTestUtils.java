package edu.project2;

import edu.project2.maze.Maze;

public class MazeTestUtils {
    public static void destroyAllWallsInMaze(Maze maze) {
        for (int i = 0; i < maze.getWidth(); i++) {
            for (int j = 0; j < maze.getHeight(); j++) {
                maze.getCell(i, j).setDestroyed(true);
            }
        }
    }

    public static String generatePrintString(int width, int height, String symbol) {
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < width; i++) {
            temp.append(symbol);
        }

        temp.append('\n');

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < height; i++) {
            result.append(temp);
        }

        return result.toString();
    }
}
