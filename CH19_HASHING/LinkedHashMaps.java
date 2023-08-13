package CH19_HASHING;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class LinkedHashMaps {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("INDIA",200);
        lhm.put("CHINA",300);
        lhm.put("RUSSIA",400);
        lhm.put("BRITAIN",500);

        System.out.println(lhm); //insertion ordered
        // {INDIA=200, CHINA=300, RUSSIA=400, BRITAIN=500}
    }
}
