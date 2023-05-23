package CH12_ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class sorting_ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);
        System.out.println("before sorting: "+list);
        Collections.sort(list);//ascending and optimised func
        System.out.println("ascending order: "+list);
        Collections.sort(list,Collections.reverseOrder());//descending order
        //here Collections.reverseOrder() is an comparator ,i.e a functiopn which defines logic
        //how sorting is to be done
        System.out.println("descending order : "+list);

    }
}
