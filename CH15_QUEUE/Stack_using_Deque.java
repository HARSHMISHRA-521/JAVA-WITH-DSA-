package CH15_QUEUE;
import java.util.*;
public class Stack_using_Deque {
    public static class Stack{
        Deque<Integer> deque = new LinkedList<>();
        //push
        public void push(int data){ //O(1)
            deque.addLast(data);
        }
        //pop
        public int pop(){ //O(1)
            return deque.removeLast();
        }
        //peek
        public int peek(){ //O(1)
            return deque.getLast();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek = "+s.peek()); //3
        System.out.println(s.pop());//3
        System.out.println(s.pop());//2
        System.out.println(s.pop());//1
    }
}
//peek = 3
//3
//2
//1