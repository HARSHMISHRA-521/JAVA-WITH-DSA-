package CH19_HASHING;
/*
VALID ANAGRAMS:
        Given two strings s and t, return true if t is an anagram of s, and false otherwise.
        An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
        typically using all the original letters exactly once.
        s = "race"     TRUE
        s = "heart"     TRUE
        s = "tulip" t = "lipid"  FALSE
*/
import java.util.*;
public class Valid_Anagrams {  // O(n)
    public static boolean isAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0;i <s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.get(ch)!= null){
                if(map.get(ch) == 1){
                    map.remove(ch);
                }
                else {
                    map.put(ch,map.get(ch)-1);
                }
            }else{
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "race";
        String t= "care";
        String p = "pace";
        System.out.println(isAnagram(s,t)); //true
        System.out.println(isAnagram(s,p)); //false
    }
}
