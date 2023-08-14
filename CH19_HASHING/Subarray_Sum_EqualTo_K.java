package CH19_HASHING;
//Subarray sum equal to K
//        return number of such subarrays
//        arr = {1,2,3}  k = 3
//        ans = 2 (1, 2) (3)

import java.util.*;
public class Subarray_Sum_EqualTo_K { //O(n)
    public static void main(String[] args) {
        int arr[]= {10,2,-2,-20,10};
        int k = -10;
        HashMap<Integer,Integer> map = new HashMap<>();
        //(sum,count)
        map.put(0,1);

        int sum =0;
        int ans = 0;

        for(int j =0;j<arr.length;j++){
            sum += arr[j];
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        System.out.println("The no of subarray exists are : "+ans);
    }
}
   // The no of subarray exists are : 3
