package CH11_BACKTRACKING;
//Question 3 :
//        Knight's Tour(ghoda)
//        Given a N*N board with the Knight placed on the first block of an empty board. Moving
//        according to the rules of chess, knights must visit each square exactly once. Print the order of
//        each cell in which they are visited.j
//        Sample Input 1 : N = 8,

//        Sample Output 1
//        0 59 38 33 30 17 8 631
//        å7 34 31 60 9 62 29 16/
//        58 1 36 39 32 27 18 7
//        65 48 41 26 61 10 15
//        42 57 24 94 02 36 19
//        47 50 45 54 25 20 11 14t
//        56 43 52 3 22 1324 5
//        61 46 55 44 53 4 21 12

//        Hint :Similar to N Queens))

public class KnightsTour {
    private static final int N = 8; // Size of the chessboard
    private static int[][] board; // Chessboard to track the tour
    private static int moveCount; // Counter to track the number of moves


    // Recursive function to solve the Knight's Tour
    private static void solveKnightsTour(int row, int col) {
        board[row][col] = moveCount; // Mark the current position with the move count

        if (moveCount == N * N) {
//            printChessboard(); // If all cells have been visited, print the final chessboard configuration
            return; // Stop recursion
        }

        int[][] moves = {
                {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, // Possible moves in L-shape
                {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
        };

        for (int i = 0; i < moves.length; i++) {
            int newRow = row + moves[i][0];
            int newCol = col + moves[i][1];

            if (isValidMove(newRow, newCol)) {
                moveCount++; // Increment the move count
                solveKnightsTour(newRow, newCol); // Recursively solve the Knight's Tour from the new position

                if (moveCount == N * N) {
//                    printChessboard(); // If all cells have been visited, print the final chessboard configuration
                    return; // Stop recursion
                }

                moveCount--; // Decrement the move count (backtracking)
                board[newRow][newCol] = 0; // Reset the board position (backtracking)
            }
        }
    }

    // Function to check if a move is valid
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N && board[row][col] == 0; // Check if the move is within the chessboard boundaries and the cell has not been visited
    }

    // Function to print the final chessboard configuration
    private static void printChessboard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        board = new int[N][N]; // Initialize the chessboard
        moveCount = 1; // Initialize the move counter
        solveKnightsTour(0, 0); // Start solving the Knight's Tour from the top-left corner
        printChessboard(); // Print the final chessboard configuration
    }

}

//
//    The approach to solve the Knight's Tour problem using backtracking is as follows:
//
//        Define the size of the chessboard as N (in this case, N = 8).
//        Create a 2D array board to represent the chessboard. Initialize all cells
//        with 0, indicating that they have not been visited yet.
//        Define a moveCount variable to keep track of the current move number.
//        Start the solving process by calling the solveKnightsTour function with the
//        initial position (0, 0) (top-left corner).
//        Inside the solveKnightsTour function:
//        Mark the current position with the current moveCount.
//        Check if all cells have been visited (moveCount equals N * N). If true, print the
//final chessboard configuration and return to stop the recursion.
//        Define an array moves containing all possible Knight moves in an L-shape.
//        Iterate through each move:
//        Calculate the new position by adding the move offsets to the current position.
//        Check if the new position is a valid move by calling the isValidMove function.
//        If the move is valid:
//        Increment the moveCount.
//        Recursively call solveKnightsTour with the new position.
//        Check if all cells have been visited (moveCount equals N * N). If true, print the final
//chessboard configuration and return to stop the recursion.
//        Decrement the moveCount (backtracking) and reset the board position (backtracking).
//        Implement the isValidMove function to check if a move is valid. It checks if the move
//        is within the chessboard boundaries and the cell has not been visited.
//        Implement the printChessboard function to print the final chessboard configuration.
//        The algorithm explores all possible paths on the chessboard using a depth-first search
//        approach. It keeps track of the visited cells and backtracks when necessary to find all possible solutions.
//        If a valid solution is found (all cells are visited), it is printed. The algorithm continues to explore
//        other paths until all possibilities have been exhausted.