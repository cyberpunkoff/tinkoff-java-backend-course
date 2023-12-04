package edu.project2.generators;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrimsAlgorithmMazeGenerator implements MazeGenerator {
    private final List<Cell> cellsForMazePassage = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public void generateMaze(Maze maze) {
        int width = maze.getWidth();
        int height = maze.getHeight();

        Cell start = maze.getCell(
            random.nextInt(width / 2) * 2 + 1,
            random.nextInt(height / 2) * 2 + 1
        );

        start.setDestroyed(true);
        cellsForMazePassage.add(start);
        while (!cellsForMazePassage.isEmpty()) {
            int index = random.nextInt(cellsForMazePassage.size());
            Cell currentCell = cellsForMazePassage.get(index);
            cellsForMazePassage.remove(index);
            Cell nextCell = MazeGenerator.getRandomCell(maze, currentCell);

            while (nextCell != null) {
                nextCell.setVisited(true);
                nextCell.setDestroyed(true);
                Cell middleCell = maze.getCell(
                    (currentCell.getX() + nextCell.getX()) / 2,
                    (currentCell.getY() + nextCell.getY()) / 2
                );
                middleCell.setDestroyed(true);
                middleCell.setVisited(true);

                cellsForMazePassage.add(nextCell);
                nextCell = MazeGenerator.getRandomCell(maze, currentCell);
            }
        }
    }
}

