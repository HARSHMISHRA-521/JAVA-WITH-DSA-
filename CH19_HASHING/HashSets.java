package CH19_HASHING;
import java.util.HashSet;
public class HashSets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        //add
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(7);
        System.out.println(set); //[1, 2, 3, 5, 7]

        if(set.contains(3)){
            System.out.println("Contains 3");  //Contains 3
        }
        set.remove(3);
        if(set.contains(3)){
            System.out.println("Contains 3"); // nothing printed
        }

        System.out.println(set.isEmpty()); //false
        System.out.println(set.size()); //4
        set.clear();
        System.out.println(set.size()); //0
        System.out.println(set.isEmpty()); //true


    }
}
