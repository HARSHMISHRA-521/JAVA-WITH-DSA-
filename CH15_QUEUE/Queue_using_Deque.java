package CH15_QUEUE;

import java.util.*;
public class Queue_using_Deque  {
    public static class Queue{
        Deque<Integer> deque = new LinkedList<>();
        //push
        public void add(int data){ //O(1)
            deque.addLast(data);
        }
        //pop
        public int remove(){ //O(1)
            return deque.removeFirst();
        }
        //peek
        public int peek(){ //O(1)
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek = "+q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
//output:
// peek = 1
//1
//2
//3
