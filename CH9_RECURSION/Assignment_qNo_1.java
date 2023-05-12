//Question 1 : For a given integer array of size N. You have to find all
//        the occurrences
//        (indices) of a given element (Key) and print them. Use a
//        recursive function to solve this
//        problem.
//        sample Input : arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2}, key = 2
//        Sample Output
//        : 1578



package CH9_RECURSION;

public class Assignment_qNo_1 {
    public static void  printIndices(int arr[],int key , int i,int count ){

        if(i==arr.length){
            System.out.println("\n"+count+" times ");
            return;
        }

        if(arr[i] == key ){
            System.out.print(i+" ");
            count ++ ;
        }
        printIndices(arr,key,i+1,count);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3,5,6,8,9,3,2};
        printIndices(arr,2,0,0);
    }
}
