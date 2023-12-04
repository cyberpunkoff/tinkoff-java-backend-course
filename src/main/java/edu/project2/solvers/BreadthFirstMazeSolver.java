package edu.project2.solvers;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
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

            List<Cell> neighbours = MazeSolver.getNeighbours(maze, current, path);

            for (Cell neighbour : neighbours) {
                if (!path.containsKey(neighbour)) {
                    path.put(neighbour, current);
                    queue.add(neighbour);
                }
            }
        }

        maze.setSolution(MazeSolver.createPath(start, target, path));
    }
}
