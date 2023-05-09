public class print_subarrays {
    public static void subarray(int arr[]){
        int noofsubarr= arr.length*(arr.length+1);//sum of n numbers
        for(int i=0;i<arr.length;i++){
            for(int j=i;j< arr.length;j++){
                System.out.print("["+" ");
                for(int k=i;k<=j;k++) {
                    System.out.print(arr[k]+" ");
                    if(k!=j){
                        System.out.print(",");
                    }
                }
                System.out.print("] ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println("Total no.of subarrays are : "+noofsubarr);
    }
    public static void main(String[] args) {
            int arr[]={1,2,3,4,5,6,7,8,9,10};
            subarray(arr);
    }
}
