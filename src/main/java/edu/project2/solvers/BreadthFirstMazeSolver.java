package edu.project2.solvers;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstMazeSolver implements MazeSolver {
    @Override
    public void solveMaze(Maze maze) {
        Map<Cell, Cell> path = new HashMap<>();
        Queue<Cell> queue = new LinkedList<>();
        Cell start = maze.getCell(1, 1);
        path.put(start, null);
        Cell target = maze.getCell(maze.getWidth() - 2, maze.getHeight() - 2);

        queue.add(start);

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            if (current.equals(target)) {
                break;
            }

            List<Cell> neighbours = getNeighbours(maze, current, path);

            for (Cell neighbour : neighbours) {
                if (!path.containsKey(neighbour)) {
                    path.put(neighbour, current);
                    queue.add(neighbour);
                }
            }
        }

        List<Cell> pathCells = new ArrayList<>();

        while (!target.equals(start)) {
            pathCells.add(target);
            target = path.get(target);
        }

        pathCells.add(start);
        maze.setSolution(pathCells);
    }

    private List<Cell> getNeighbours(Maze maze, Cell currentCell, Map<Cell, Cell> path) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        List<Cell> neighbours = new ArrayList<>();

        for (int i = 0; i < dx.length; i++) {
            if (maze.isValidCell(currentCell.getX() + dx[i], currentCell.getY() + dy[i])) {
                Cell tempCell = maze.getCell(currentCell.getX() + dx[i], currentCell.getY() + dy[i]);

                if (!path.containsKey(tempCell) && tempCell.isDestroyed()) {
                    neighbours.add(tempCell);
                }
            }

        }
        return neighbours;
    }
}
