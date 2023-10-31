package edu.project2.generators;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RecursiveBacktrackingMazeGenerator implements MazeGenerator {
    @Override public void generateMaze(Maze maze) {
        int startX = 0;
        int startY = 0;
        Cell currentCell = maze.getCell(1, 1);

        Stack<Cell> cells = new Stack<>();
        boolean firstCell = true;

        while (true) {
            if (firstCell) {
                firstCell = false;
            }

            Cell nextCell = getRandomCell(maze, currentCell);

            if (nextCell != null) {
                nextCell.setVisited(true);
                nextCell.setDestroyed(true);
                Cell middleCell = maze.getCell(
                    (currentCell.getX() + nextCell.getX()) / 2,
                    (currentCell.getY() + nextCell.getY()) / 2
                );
                middleCell.setDestroyed(true);
                middleCell.setVisited(true);

                cells.push(currentCell);
                currentCell = nextCell;

            } else if (!cells.isEmpty()) {
                currentCell = cells.pop();
            } else {
                break;
            }

        }
    }

    @SuppressWarnings("MagicNumber")
    private Cell getRandomCell(Maze maze, Cell currentCell) {
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


