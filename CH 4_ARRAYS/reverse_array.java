public class reverse_array {
    public static void rev(int arr[]){
        int start =0, end = arr.length-1;
        int temp =0;
        while(start<end){
             temp = arr[end];
            arr[end] =arr[start];
            arr[start]= temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
            int arr[]={1,2,3,4,5,6,7,8,9,10};
                System.out.println("ARRAY BEFORE REVERSE IS :");
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            rev(arr);
        System.out.println();
            System.out.println("ARRAY AFTER REVERSE IS :");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
