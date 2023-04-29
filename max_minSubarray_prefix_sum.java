public class max_minSubarray_prefix_sum {
    public static void subarray(int arr[]){
        int noofsubarr= arr.length*(arr.length+1);//sum of n numbers
        int maxSum = Integer.MIN_VALUE; // initialize maxSum to the smallest integer value
        int minSum = Integer.MAX_VALUE; // initialize minSum to the largest integer value
        int prefix[] = new int[arr.length];

//        calculate prefix
        prefix[0]=arr[0];
        for(int i = 1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }

        for(int i=0;i<arr.length;i++){
            int start =i;
            for(int j=i;j< arr.length;j++){
                int end = j;
                int sum = start ==0 ?prefix[end]:prefix[end]-prefix[start-1];


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
        int arr[]={1,4,5,10,6,7,8,9};
        subarray(arr);
    }
}
