package CH11_BACKTRACKING;
//Question 1
//        Rat in a Maze
//        You are given a starting position for a rat which is stuck in a maze at an initial point (0, 0) (the
//        maze can be thought of as a 2-dimensional plane). The maze would be given in the form of a
//        square matrix of order N * N where the cells with value 0 represent the maze's blocked
//        locations while value 1 is the open/available path that the rat can take to reach its destination.
//        The rat's destination is at (N - 1, N - 1).
//        Your task is to find all the possible paths that the rat can take to reach from source to
//        destination in the maze.
//        The possible directions that it can take to move in the maze are 'U'(up) i.e. (x, y - 1) , 'D'(down)
//        i.e. (x, y + 1) , 'L' (left) i.e. (x - 1, y), 'R' (right) i.e. (x + 1, y).
//

public class MazeSolver {
    private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution, int N) {
        // Base case: If reached the destination (bottom-right cell)
        if (x == N - 1 && y == N - 1) {
            solution[x][y] = 1;
            printSolution(solution, N);
            return true;
        }

        // Check if current position is a valid move
        if (isSafe(maze, x, y, N)) {
            // Mark current position as part of the solution path
            solution[x][y] = 1;

            // Move to the right (R)
            if (solveMazeUtil(maze, x + 1, y, solution, N))
                return true;

            // Move down (D)
            if (solveMazeUtil(maze, x, y + 1, solution, N))
                return true;

            // Move left (L)
            if (solveMazeUtil(maze, x - 1, y, solution, N))
                return true;

            // Move up (U)
            if (solveMazeUtil(maze, x, y - 1, solution, N))
                return true;

            // If none of the above moves lead to the destination, backtrack
            solution[x][y] = 0;
        }

        return false;
    }

    private static boolean isSafe(int[][] maze, int x, int y, int N) {
        // Check if current position is within the maze boundaries and is an open path (1)
        return x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1;
    }

    private static void printSolution(int[][] solution, int N) {
        System.out.println("Solution path:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int N = 4; // Size of the maze
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        int[][] solution = new int[N][N]; // Solution matrix to track the path

        if (!solveMazeUtil(maze, 0, 0, solution, N)) {
            System.out.println("No solution exists.");
        }
    }
}

//
//    Declare and initialize the size of the maze (N) and the maze itself (maze) with 0s and 1s,
//        where 0 represents blocked locations and 1 represents open paths.
//
//        Create a solution matrix (solution) of the same size as the maze to track the path of the rat.
//
//        Call the solveMazeUtil function with the initial position of the rat at (0, 0), the maze, the solution
//        matrix, and the size N.
//
//        Inside the solveMazeUtil function:
//
//        Check if the current position is the destination (bottom-right cell) by comparing the current
//        coordinates (x and y) with (N - 1, N - 1).
//        If the destination is reached:
//        Mark the current position as part of the solution path by setting the corresponding cell
//        in the solution matrix to 1.
//        Print the solution matrix.
//        Return true to indicate that a solution has been found.
//        If the current position is a valid move:
//        Mark the current position as part of the solution path by setting the corresponding cell in the
//        solution matrix to 1.
//        Recursively call the solveMazeUtil function for the next possible moves in the following
//        order: right (R), down (D), left (L), and up (U).
//        If any of the recursive calls return true, it means a solution has been found, so return true.
//        If none of the moves lead to the destination, backtrack by setting the current position in the solution
//        matrix back to 0 and return false.
//        After the solveMazeUtil function call in the main function, check if a solution was found. If not,
//        print a message indicating that no solution exists.
//
//        The isSafe function checks if the current position is within the
//        maze boundaries (x >= 0 && x < N && y >= 0 && y < N) and is an open path (maze[x][y] == 1).
//
//        The printSolution function is used to print the path of the rat stored in the solution matrix.