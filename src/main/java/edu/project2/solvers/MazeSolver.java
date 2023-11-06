package edu.project2.solvers;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface MazeSolver {
    void solveMaze(Maze maze);

    static List<Cell> createPath(Cell start, Cell finish, Map<Cell, Cell> connections) {
        List<Cell> pathCells = new ArrayList<>();
        Cell target = finish;

        while (!target.equals(start)) {
            pathCells.add(target);
            target = connections.get(target);
        }

        pathCells.add(start);
        return pathCells;
    }

    static List<Cell> getNeighbours(Maze maze, Cell currentCell, Map<Cell, Cell> path) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        List<Cell> neighbours = new ArrayList<>();

        for (int i = 0; i < dx.length; i++) {
            if (maze.isValidCell(currentCell.getX() + dx[i], currentCell.getY() + dy[i])) {
                Cell tempCell = maze.getCell(currentCell.getX() + dx[i], currentCell.getY() + dy[i]);

                if (path == null || !path.containsKey(tempCell) && tempCell.isDestroyed()) {
                    neighbours.add(tempCell);
                }
            }

        }
        return neighbours;
    }
}
