package CH11_BACKTRACKING;

public class nQueens_1Sol { // O(n!)

    public static boolean isSafe(char board[][], int row, int col) {
        // Check if there is a Queen in the vertical upward direction
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check if there is a Queen in the diagonal left-up direction
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check if there is a Queen in the diagonal right-up direction
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // It is safe to place a Queen at the current position
        return true;
    }

    public static void printBoard(char board[][]) {
        System.out.println("\n---------------------- chess board --------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" | " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean nQueens(char board[][], int row) {
        // Base case: If all rows have been filled, we have found a valid placement
        if (row == board.length) {
            return true;
        }

        // Loop through each column in the current row
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                // Place a Queen at the current position
                board[row][j] = 'Q';

                // Recursive call to solve the problem for the next row
                if (nQueens(board, row + 1)) {
                    return true;
                }

                // Backtracking step: Undo the placement of the Queen
                board[row][j] = 'x';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 2;
        char board[][] = new char[n][n];

        // Initialize the board with empty positions
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'x';
            }
        }

        // Solve the N-Queens problem starting from the first row
        if (nQueens(board, 0)) {
            System.out.println("Solution is possible");
            printBoard(board);
        } else {
            System.out.println("Solution is not possible");
        }
    }
}
