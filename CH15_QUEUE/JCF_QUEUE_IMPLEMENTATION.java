package CH15_QUEUE;
import java.util.*;
public class JCF_QUEUE_IMPLEMENTATION {
    public static void main(String[] args) {
        Queue<Integer> q =new LinkedList<>();
                  //or
       // Queue<Integer> q =new ArrayDeque<>();

        //here,we use only LinkedLIst and ArrayDeque for implementation of queue because QUEUE is an interface and its
        //object can not be created .
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());  //1 2 3
            q.remove();
        }
    }
}
