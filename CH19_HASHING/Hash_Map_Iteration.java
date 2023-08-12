package CH19_HASHING;

import java.util.*;

public class Hash_Map_Iteration {
    public static void main(String[] args) {
        //create
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Russia", 250);
        System.out.println(hm); //{China=150, US=50, India=100, Russia=250}

        //iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys); //[China, US, India, Russia]

        for(String k:keys)
        {
            System.out.println("Key = "+k + ", value = "+hm.get(k));
        }
        /*

         Key = China, value = 150
          Key = US, value = 50
        Key = India, value = 100
        Key = Russia, value = 250  */

        //or we can use hm.entrySet(),this gives set of all pairs

        Set<Map.Entry<String, Integer>> key  = hm.entrySet();
        System.out.println(key); //[China=150, US=50, India=100, Russia=250]

    }
}
