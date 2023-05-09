public class search_in_sorted_matrix {
    public static boolean staircaseSearch(int matrix[][],int key){
        int row =0,col=matrix[0].length-1; // it is solved by taking the case from (0,m-1)special cell to (n-1,0)
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==key){ // if key is found at this position
                System.out.println("found key at ("+row+","+col+")");
                return true;
            } else if (key > matrix[row][col]) { // if key is greater than the current element
                row++; // move to the next row (towards the bottom)
            }
            else { // if key is smaller than the current element
                col--; // move to the previous column (towards the left)
            }
        }
        // if we haven't found the key, it is not present in the matrix
        System.out.println("key not found!");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        int key = 33;
        staircaseSearch(matrix,key); // call the staircaseSearch function with the matrix and key
    }
}

//
//        The code performs a staircase search in a sorted matrix for a given key.
//        It achieves this by starting from the top-right corner of the matrix,
//        which is a "special" cell because all elements to its left are smaller
//        and all elements below it are larger. Then, it performs a binary
//        search-like approach by either moving towards the bottom row or the
//        leftmost column, depending on whether the key is greater or smaller than the
//        current element. It repeats this process until it either
//        finds the key or exhausts all possibilities. Finally,
//        it returns true if the key is found, or false otherwise.