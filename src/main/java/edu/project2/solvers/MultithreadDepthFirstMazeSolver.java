package edu.project2.solvers;

import edu.project2.maze.Cell;
import edu.project2.maze.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MultithreadDepthFirstMazeSolver implements MazeSolver {
    private Maze maze;
    private Map<Cell, Cell> path;
    Cell start;
    Cell target;

    @Override
    public void solveMaze(Maze maze) {
        this.maze = maze;
        this.path = new ConcurrentHashMap<>();
        this.start = maze.getCell(1, 1);
        this.target = maze.getCell(maze.getWidth() - 2, maze.getHeight() - 2);

        try(ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            forkJoinPool.invoke(new RecursiveMazeSolver(start));
        }

        maze.setSolution(MazeSolver.createPath(start, target, path));
    }

    class RecursiveMazeSolver extends RecursiveAction {
        Cell currentCell;

        RecursiveMazeSolver(Cell cell) {
            this.currentCell = cell;
        }

        @Override
        protected void compute() {
            if (!currentCell.equals(target)) {
                List<Cell> neighbours = MazeSolver.getNeighbours(maze, currentCell, path);
                List<RecursiveMazeSolver> subTasks = new ArrayList<>();
                for (Cell neighbour : neighbours) {
                    if (!path.containsKey(neighbour)) {
                        path.put(neighbour, currentCell);
                        RecursiveMazeSolver recursiveMazeSolver = new RecursiveMazeSolver(neighbour);
                        subTasks.add(recursiveMazeSolver);
                    }
                }

                invokeAll(subTasks);
            }
        }
    }

}
