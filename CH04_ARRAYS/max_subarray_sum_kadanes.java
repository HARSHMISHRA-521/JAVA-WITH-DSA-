public class max_subarray_sum_kadanes {
    public static void kadanes(int arr[]){
        int maxsum = Integer.MIN_VALUE;
        int msum = Integer.MIN_VALUE;
        int cursum=0;
        for(int i=0;i<arr.length;i++){
            cursum+=arr[i];
            msum =Math.max(cursum,msum);
            if(cursum<0){
                cursum=0;
            }
            maxsum =Math.max(cursum,maxsum);
        }
        if(maxsum==0) {
            System.out.println("The array contains all -ve numbers and max sum is : " + msum);
        }
        else{
            System.out.println("The max sum is : "+maxsum);
        }
    }

    public static void main(String[] args) {
        int arr[]={-2,-3,-4,-2,-11,-5,-3};
        kadanes(arr);
    }
}
