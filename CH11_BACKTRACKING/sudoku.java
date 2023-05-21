package CH11_BACKTRACKING;

public class sudoku {
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        // Check column
        for (int i = 0; i <= 8; i++) {
            if (sudoku[row][i] == digit) {
                return false;
            }
        }

        // Check row
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // Check 3x3 grid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // Base case: all cells have been filled
        if (row == 9) {
            return true;
        }

        // Move to the next cell
        int nextRow = row;
        int nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // If the current cell is already filled, move to the next cell
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        // Try placing digits from 1 to 9 in the current cell
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol)) {
                    // Solution exists
                    return true;
                }
                sudoku[row][col] = 0; // Backtrack by undoing the current placement
            }
        }
        return false;
    }

//    public static void printSudoku(int sudoku[][]) {
//        System.out.println("----------------------  SUDOKU  ---------------------------");
//        System.out.println("------------------------------------------------------------");
//        for (int i = 0; i < 9; i++) {
//            System.out.print("  |  ");
//            for (int j = 0; j < 9; j++) {
//                System.out.print(sudoku[i][j] + "  |  ");
//            }
//            System.out.println();
//            System.out.println("------------------------------------------------------------");
//        }
//    }

    //for printing real box like sudoku
    public static void printSudoku(int sudoku[][]) {
        System.out.println("------------------------- SUDOKU -------------------------");
        System.out.println("+-------+-------+-------+");

        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("|-------+-------+-------|");
            }

            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                if (sudoku[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(sudoku[i][j] + " ");
                }
            }
            System.out.println("|");
        }

        System.out.println("+-------+-------+-------+");
    }


    public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists:");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution does not exist.");
        }
    }
}
