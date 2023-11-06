package edu.project2.maze;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private Cell[][] map;
    private final int width;
    private final int height;
    private List<Cell> solution = new ArrayList<>();

    public Maze(int width, int height) {
        if (width % 2 == 0) {
            this.width = width + 1;
        } else {
            this.width = width;
        }

        if (height % 2 == 0) {
            this.height = height + 1;
        } else {
            this.height = height;
        }

        map = new Cell[this.width][this.height];

        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                map[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return map[x][y];
    }

    public boolean isValidCell(int x, int y) {
        return (x > 0 && x < width - 1) && (y > 0 && y < height - 1);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isInSolution(Cell cell) {
        return this.solution.contains(cell);
    }

    public void setSolution(List<Cell> pathCells) {
        this.solution = pathCells;
    }
}
