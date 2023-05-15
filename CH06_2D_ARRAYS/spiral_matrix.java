public class spiral_matrix {
    public static void printspiral(int matrix[][]){
        int startrow = 0; // initialize the starting row index
        int startcol = 0; // initialize the starting column index
        int endrow = matrix.length-1; // initialize the ending row index
        int endcol = matrix[0].length-1; // initialize the ending column index

        // loop until all elements in the matrix are visited
        while (startrow <= endrow && startcol <= endcol) {

            // print the elements in the top row
            for (int j = startcol; j <= endcol; j++) {
                System.out.print(matrix[startrow][j] + " ");
            }

            // print the elements in the rightmost column
            for (int i = startrow + 1; i <= endrow; i++) {
                System.out.print(matrix[i][endcol] + " ");
            }

            // print the elements in the bottom row, if applicable
            for (int j = endcol - 1; j >= startcol; j--) {
                if (startrow == endrow) { // check if there is only one row left
                    break; // exit the loop
                }
                System.out.print(matrix[endrow][j] + " ");
            }

            // print the elements in the leftmost column, if applicable
            for (int i = endrow - 1; i >= startrow + 1; i--) {
                if (startcol == endcol) { // check if there is only one column left
                    break; // exit the loop
                }
                System.out.print(matrix[i][startcol] + " ");
            }

            // update the starting and ending indices for the next iteration
            startrow++;
            startcol++;
            endcol--;
            endrow--;
        }
    }

    public static void main(String[] args) {
        int matrix[][]= {{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printspiral(matrix);
    }
}
