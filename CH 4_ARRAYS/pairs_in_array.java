public class pairs_in_array {
    public static void pairs(int arr[]){
        int totalpair= arr.length*(arr.length-1)/2;//sum of n-1 numbers
        for(int i=0;i<arr.length;i++){
            int cur =arr[i];
            for(int j=i+1;j<arr.length;j++){
                System.out.print("("+cur+","+arr[j]+")");
            }
            System.out.println();
        }
        System.out.println("Total numbers of pairs are : "+totalpair);
    }
    public static void main(String[] args) {
        int arr[]={2,4,5,6,7,8,9,10};
        pairs(arr);

    }
}
