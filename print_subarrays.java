public class print_subarrays {
    public static void subarray(int arr[]){
        int noofsubarr= arr.length*(arr.length+1);//sum of n numbers
        int maxSum = Integer.MIN_VALUE; // initialize maxSum to the smallest integer value
        int minSum = Integer.MAX_VALUE; // initialize minSum to the largest integer value
        for(int i=0;i<arr.length;i++){
            for(int j=i;j< arr.length;j++){
                int sum = 0; // initialize sum for each subarray
                System.out.print("["+" ");
                for(int k=i;k<=j;k++) {
                    System.out.print(arr[k]+" ");
                    sum += arr[k]; // add each element to the sum
                    if(k!=j){
                        System.out.print(",");
                    }
                }
                System.out.print("] ");
                System.out.println("Sum: " + sum); // print the sum of each subarray
                if(sum > maxSum) { // update maxSum if necessary
                    maxSum = sum;
                }
                if(sum < minSum) { // update minSum if necessary
                    minSum = sum;
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println("Total no.of subarrays are : "+noofsubarr);
        System.out.println("Maximum sum of subarrays is : "+ maxSum);
        System.out.println("Minimum sum of subarrays is : "+ minSum);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        subarray(arr);
    }
}
