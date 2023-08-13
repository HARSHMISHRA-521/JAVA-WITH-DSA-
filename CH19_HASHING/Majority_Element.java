package CH19_HASHING;
/*
Majority Element
        Given an integer array of size n, find all elements that appear more than [n/3 ] times.

        nums[ ] = {1 , 3, 2, 5, 1, 3, 1, 5, 1};
         // 1
        nums[] =  {1, 2};
        //1 , 2
*/

import java.util.*;
public class Majority_Element {  // O (n)
    public static void main(String[] args) {
        int arr[] = {1,3,2,5,1,3,1,5,1};
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<arr.length;i++){
//            if(map.containsKey(arr[i])){
//                map.put(arr[i],map.get(arr[i])+1);
//            }
//            else{
//                map.put(arr[i],1);
//            }

                   // or shortcut :
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

//        Set<Integer> keyset = map.keySet();
//        for(Integer key : keyset){
//            if(map.get(key)>arr.length/3){
//                System.out.println(key);  //1
//            }
//        }

           // or shortcut
       // Set<Integer> keyset = map.keySet();
        for(Integer key :  map.keySet()){
            if(map.get(key)>arr.length/3){
                System.out.println(key);  //1
            }
        }
    }

}
