package CH15_QUEUE; // O(n)
import java.util.*;
//First non repeating  letter in a stream of character
//** remember often "stream of characters " in a question refers to use of queue in the code
public class first_nonrepeating_letter {
    public static void printNonRepeating(String str){
        int freq[]= new int[26]; // 'a' - 'z'
        Queue<Character> q = new LinkedList<>();

        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }
            else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);  // output : a -1 b b b b x
    }
}
