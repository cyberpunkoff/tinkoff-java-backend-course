package edu.project2;

import edu.project2.generators.MazeGenerator;
import edu.project2.generators.PrimsAlgorithmMazeGenerator;
import edu.project2.maze.Maze;
import edu.project2.output.ConsoleMazePrinter;
import edu.project2.output.MazePrinter;
import edu.project2.solvers.DepthFirstMazeSolver;
import edu.project2.solvers.MazeSolver;

public final class Main {
    private final static int MAZE_WIDTH = 20;
    private final static int MAZE_HEIGHT = 15;

    private Main() {
    }

    public static void main(String[] args) {

        Maze maze = new Maze(MAZE_WIDTH, MAZE_HEIGHT);
        MazeGenerator mazeGenerator = new PrimsAlgorithmMazeGenerator();
        MazeSolver mazeSolver = new DepthFirstMazeSolver();
        MazePrinter mazePrinter = new ConsoleMazePrinter();

        mazeGenerator.generateMaze(maze);
        mazePrinter.printMaze(maze);
        mazeSolver.solveMaze(maze);
        mazePrinter.printMaze(maze);
    }
}
