//Tiling Problem
//        Given a "2 x n" floor and tiles of size "2 x 1", count the number of
//        ways to tile the given board using the 2 x 1 tiles.
//        (A tile can either be placed horizontally or vertically. )

package CH9_RECURSION;

public class Tiling_porblem {
    public static int tiling_problem(int width){ //2 x width size

        //base case
        if(width == 0 || width ==1){
            return 1;
        }

        //vertical choice
        int fnm1 = tiling_problem(width -1);

        //horizontal choice
        int fnm2 = tiling_problem(width-2);

        int totalWays = fnm1 + fnm2;
        return totalWays;
    }

    public static void main(String[] args) {
        int width = 5;
        System.out.println(tiling_problem(width) +" ways ");
    }
}
