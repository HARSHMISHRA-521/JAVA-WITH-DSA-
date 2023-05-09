public class selection_sort {
    public static void selection(int[] arr){
        int n = arr.length;
        for(int i =0;i< n-1;i++){
            int minpos =i;
            for(int j=i+1;j<n;j++){
                if(arr[minpos]>arr[j]){
                    minpos=j;
                }
            }

            //swap
            int temp = arr[minpos];
            arr[minpos]=arr[i];
            arr[i]=temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int [] arr ={4,1,3,5,2};
        System.out.println("Array before sorting");
        printArray(arr);
        selection(arr);
        System.out.println("Array after sorting");
        printArray(arr);
    }


}
