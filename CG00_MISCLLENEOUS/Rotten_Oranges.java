package CG00_MISCLLENEOUS;
/*
994. Rotting Oranges:
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
"https://www.youtube.com/watch?v=yf3oUhkvqA0"
 */
import java.util.*;
public class Rotten_Oranges {  // TC = SC  = O( row * col)
    static class Orange {
        int row, col, time;

        Orange(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int elapsedMinutes = 0;
        int totalOranges = 0, rottenOranges = 0;
        Queue<Orange> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Orange(i, j, elapsedMinutes));
                    rottenOranges++;
                }
                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    totalOranges++;
                }
            }
        }

        System.out.println("Rotten Oranges: " + rottenOranges);
        System.out.println("Total Oranges: " + totalOranges);

        while (!queue.isEmpty()) {
            Orange currentOrange = queue.poll();
            int currentRow = currentOrange.row;
            int currentCol = currentOrange.col;

            // Check left
            if (currentRow > 0 && grid[currentRow - 1][currentCol] == 1) {
                queue.add(new Orange(currentRow - 1, currentCol, currentOrange.time + 1));
                grid[currentRow - 1][currentCol] = 2;
                rottenOranges++;
            }

            // Check top
            if (currentCol > 0 && grid[currentRow][currentCol - 1] == 1) {
                queue.add(new Orange(currentRow, currentCol - 1, currentOrange.time + 1));
                grid[currentRow][currentCol - 1] = 2;
                rottenOranges++;
            }

            // Check right
            if (currentRow < grid.length - 1 && grid[currentRow + 1][currentCol] == 1) {
                queue.add(new Orange(currentRow + 1, currentCol, currentOrange.time + 1));
                grid[currentRow + 1][currentCol] = 2;
                rottenOranges++;
            }

            // Check bottom
            if (currentCol < grid[0].length - 1 && grid[currentRow][currentCol + 1] == 1) {
                queue.add(new Orange(currentRow, currentCol + 1, currentOrange.time + 1));
                grid[currentRow][currentCol + 1] = 2;
                rottenOranges++;
            }

            elapsedMinutes = currentOrange.time;
            System.out.println("Elapsed Minutes: " + elapsedMinutes);
        }

        if (totalOranges != rottenOranges) {
            return -1;
        }

        return elapsedMinutes;
    }

}
