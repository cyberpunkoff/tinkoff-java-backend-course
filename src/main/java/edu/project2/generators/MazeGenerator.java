package edu.project2.generators;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface MazeGenerator {
    void generateMaze(Maze maze);

    static Cell getRandomCell(Maze maze, Cell currentCell) {
        int[] dx = {-2, 0, 2, 0};
        int[] dy = {0, -2, 0, 2};

        List<Integer> indexList = new ArrayList<>(List.of(0, 1, 2, 3));
        Collections.shuffle(indexList);

        for (int j = 0; j < dx.length; j++) {
            int i = indexList.get(j);

            if (maze.isValidCell(currentCell.getX() + dx[i], currentCell.getY() + dy[i])) {
                Cell tempCell = maze.getCell(currentCell.getX() + dx[i], currentCell.getY() + dy[i]);

                if (!tempCell.isVisited()) {
                    return tempCell;
                }
            }

        }
        return null;
    }
}
