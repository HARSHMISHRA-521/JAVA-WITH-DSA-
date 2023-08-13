package CH19_HASHING;
import java.util.TreeSet;

public class TreeSets {
    public static void main(String[] args) {
        TreeSet<String> cities = new TreeSet<>();
        cities.add("Bangalore");
        cities.add("Delhi");
        cities.add("Noida");
        cities.add("Dhanbad");
        System.out.println(cities);
    }// [Bangalore, Delhi, Dhanbad, Noida]  sorted in ascending order

}
