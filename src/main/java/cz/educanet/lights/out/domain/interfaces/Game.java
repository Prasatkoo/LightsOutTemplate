package cz.educanet.lights.out.domain.interfaces;

import java.util.Random;

public class Game implements ILightsOut {
    private boolean end = true;
    private int movecount;
    private boolean[][] grid = new boolean[5][5];
    private Random random = new Random();

    public Game() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = random.nextBoolean();
            }
        }

    }

    @Override
    public int getMoveCount() {
        return movecount;
    }

    @Override
    public boolean isGameOver() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]) {
                    end = false;
                }
            }
        }
        return end;
    }

    @Override
    public boolean[][] getGrid() {
        return grid;
    }

    @Override
    public void makeMove(int x, int y) {
        isInfield(x, y);
        movecount++;
    }

    public void isInfield(int x, int y) {
        boolean x1 = x + 1 <= 4;
        boolean x2 = x - 1 >= 0;
        boolean y1 = y + 1 <= 4;
        boolean y2 = y - 1 >= 0;
          grid[x][y] =! grid[x][y];
        if (x1) {grid[x + 1][y] =! grid[x + 1][y];}
        if (x2) {grid[x - 1][y] =! grid[x - 1][y];}
        if (y1) {grid[x][y + 1] =! grid[x][y + 1];}
        if (y2) {grid[x][y - 1] =! grid[x][y - 1];}
    }
}


