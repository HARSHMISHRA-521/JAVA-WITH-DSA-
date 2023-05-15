import java.util.*;
public class largest_smallest_in_arrays {
    public static int largest(int arr[]){
        int max = Integer.MIN_VALUE;//-infinity
        int min = Integer.MAX_VALUE;//+infinity
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max = arr[i];
            }
            if(min>arr[i]){
                min=arr[i];
            }
        }
        System.out.println("The minimum number is : "+min);
        return max;
    }

    public static void main(String[] args) {
        int arr []={12,85,99,100,2,40,36,99,45,42};
        int max =largest(arr);
        System.out.println("The largest number is : "+max);
    }
}
