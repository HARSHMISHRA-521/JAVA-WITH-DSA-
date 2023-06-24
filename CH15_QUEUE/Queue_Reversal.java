package CH15_QUEUE; // TC = SC = O(n)
//reverse the given queue
//eg: q = 1 2 3 4 5
// final = 5 4 3 2 1 (reversed)
import java.util.*;
public class Queue_Reversal {
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()){
            s.push(q.remove());
        }

        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q =new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reverse(q);
        //print q
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");  // output : 5 4 3 2 1
        }
        System.out.println();
    }
}
