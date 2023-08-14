package CH19_HASHING;
//Largest subarray with O sum
//        arr = (15, -2, 2, -8, 1, 7, 10, 23)
//        ans = 5
//
//        arr (3, 4, 5)
//        ans = 0
import java.util.*;
public class Largest_Subarray_With_Sum_0 {   //O(n)
    public static void main(String[] args) {
        int arr[] = {15,-2,2,-8,1,7,10,23};
        HashMap<Integer,Integer> map = new HashMap<>();
        //(sum,idx)

        int sum = 0;
        int len =0;

        for(int j=0;j<arr.length;j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len,j-map.get(sum));
            }
            else{
                map.put(sum,j);
            }
        }
        System.out.println("Largest subarray with sum as 0 = "+len);
    }
}    // Largest subarray with sum as 0 = 5
