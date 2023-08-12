package CH19_HASHING;
import java.util.HashMap;
public class HashMap_Operations {
    public static void main(String[] args) {
        //create
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Russia", 250);
        System.out.println(hm); //{China=150, US=50, India=100, Russia=250}

        //get -O(1)
        int population = hm.get("India");
        System.out.println(population); //100
        System.out.println(hm.get("Indonesia"));//null

        //containKey - O(1)
        System.out.println(hm.containsKey("India"));//true
        System.out.println(hm.containsKey("Indonesia"));//false

        //remove -O(1)
        System.out.println(hm.remove("US")); //50
        System.out.println(hm);//{China=150, India=100, Russia=250}

        //size
        System.out.println(hm.size()); //3

        //isEmpty
        System.out.println(hm.isEmpty()); //false
        hm.clear();
        System.out.println(hm.isEmpty()); //true
    }
}
