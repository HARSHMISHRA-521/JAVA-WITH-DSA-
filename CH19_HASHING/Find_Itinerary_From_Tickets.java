package CH19_HASHING;
//Find Itinerary(journey) from Tickets
//        "Chennai" -> "Bengaluru"
//        "Mumbai" -> "Delhi"
//        "Goa" -> "Chennai"
//        "Delhi" -> "Goa"

//      output:   "Mumbai" -> "Delhi"-> "Goa"-> "Chennai"-> "Bengaluru"

import java.util.*;
public class Find_Itinerary_From_Tickets { // O(n)

    public static String getStart(HashMap<String,String> tickets){
        HashMap<String,String > revMap = new HashMap<>();

        for(String key: tickets.keySet()){
            revMap.put(tickets.get(key),key);
        }

        for(String key : tickets.keySet()){
            if(!revMap.containsKey(key)){
                return key; //starting point
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String,String > tickets = new HashMap<>();
        tickets.put("Chennai","Bangalore");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for(String key:tickets.keySet()){
            System.out.print(" ==> "+tickets.get(start));
            start = tickets.get(start);
        }
        System.out.println();
    }
}
//output : Mumbai ==> Delhi ==> Goa ==> Chennai ==> Bangalore