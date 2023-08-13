package CH19_HASHING;

import java.util.LinkedHashSet;

public class LinkedHastSets {
    public static void main(String[] args) {
        LinkedHashSet<String> cities = new LinkedHashSet<>();
        cities.add("Bangalore");
        cities.add("Delhi");
        cities.add("Noida");
        cities.add("Dhanbad");
        System.out.println(cities);
    } //  [Bangalore, Delhi, Noida, Dhanbad]  order of insertion maintained
}