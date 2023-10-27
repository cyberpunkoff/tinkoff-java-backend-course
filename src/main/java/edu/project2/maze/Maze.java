package edu.project2.maze;

import java.util.HashSet;
import java.util.Set;

public class Maze {
    private Set<Cell> walls;
    private final int width;
    private final int height;

    public Maze(int width, int height) {
        walls = new HashSet<>();
        this.width = width;
        this.height = height;
    }

    public boolean isWall(Cell cell) {
        return walls.contains(cell);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
