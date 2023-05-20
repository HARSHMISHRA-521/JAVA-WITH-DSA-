package CH11_BACKTRACKING;
//
//To calculate the number of grid ways using permutations, we can consider the total number of steps required
//        to reach the destination
//        from the starting point. Since we can only move right or down, the total number of steps will
//        be the sum of the number of right moves and the number of down moves needed to reach the destination.
//
//        We can represent a right move as 'R' and a down move as 'D'. For example, in a 3x4 grid,
//        a possible sequence of moves can be "RRRDD". The total number of ways to arrange these moves
//        is equivalent to the number of permutations of this sequence.
//
//        To calculate the number of permutations, we can use the formula for calculating factorial.
//        The factorial of a number n, denoted as n!, represents the product of all positive integers
//        less than or equal to n. We can calculate n! as n * (n-1) * (n-2) * ... * 1.
//
//        In the case of grid ways, the total number of steps required is (n-1) right moves and (m-1)
//        down moves, where n is the number of rows and m is the number of columns. Therefore, the number of
//        permutations is (n-1+m-1)! / ((n-1)! * (m-1)!).


public class GridWaysPermutation {  //O(n+m)

    public static int calculateGridWays(int n, int m) {
        // Calculate the factorials
        int factorialNM = factorial(n - 1 + m - 1);
        int factorialNMinus1 = factorial(n - 1);
        int factorialMMinus1 = factorial(m - 1);

        // Calculate the number of grid ways using permutations formula
        int gridWays = factorialNM / (factorialNMinus1 * factorialMMinus1);

        return gridWays;
    }

    public static int factorial(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 4;

        int gridWays = calculateGridWays(n, m);

        System.out.println("Number of grid ways using permutations: " + gridWays);
    }
}
