package CH11_BACKTRACKING;
//
//        Write a program that creates an array of size 5. While reaching the base case in
//        the program, assign the values i + 1 to the array elements.
//        Upon returning from the base case, subtract 2 from each array element.
//        Implement the program as described.

public class ARRAY_BACKTRACKING {
    public static void changeArr(int arr[],int i){
        //base
        if(i==arr.length){
            printArr(arr);
            return;
        }

        //kaam
        arr[i]=i+1;
        changeArr(arr,i+1);//func call
        arr[i]-=2;//backtracking step

    }
    public static void printArr(int arr[]){
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArr(arr,0);
        printArr(arr);
    }
}
