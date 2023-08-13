package CH19_HASHING;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TreeMaps {
    public static void main(String[] args) {
        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("INDIA",200);
        tm.put("CHINA",300);
        tm.put("RUSSIA",400);
        tm.put("BRITAIN",500);

        System.out.println(tm); //sorted by key
        // {BRITAIN=500, CHINA=300, INDIA=200, RUSSIA=400}
    }
}
