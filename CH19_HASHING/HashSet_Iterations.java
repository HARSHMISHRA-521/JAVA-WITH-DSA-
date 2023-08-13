package CH19_HASHING;
import java.util.*;
public class HashSet_Iterations {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Bangalore");
        cities.add("Delhi");
        cities.add("Noida");
        cities.add("Dhanbad");

        //iterators
        Iterator i = cities.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        System.out.println("-------------------------------");
        //using enhanced for loop
        for(String city : cities){
            System.out.println(city);
        }
    }
}
/*Delhi
Noida
Dhanbad
Bangalore
-------------------------------
Delhi
Noida
Dhanbad
Bangalore
*/