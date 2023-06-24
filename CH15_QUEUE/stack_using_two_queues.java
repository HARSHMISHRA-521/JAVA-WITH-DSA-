package CH15_QUEUE;
import java.util.*;
public class stack_using_two_queues {
    static class Stack{
        static Queue<Integer> q1  =new LinkedList<>();
        static Queue<Integer> q2  =new LinkedList<>();
        static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){ //O(1)
            if(!q1.isEmpty()){
                q1.add(data);  //push into the queue which is non empty
            }
            else{
                q2.add(data);
            }

        }

        public static int pop(){ //O(n)
            if(isEmpty()){
                System.out.println("Empty stack!");
                return -1;
            }
            int top = -1;
            //case 1 (q1 -> q2)
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }
            else { //case 2  (q2-> q1)
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;

        }

        //peek
        public static int peek(){ //O(n)
            if(isEmpty()){
                System.out.println("Empty stack!");
                return -1;
            }
            int top = -1;
            //case 1 (q1 -> q2)
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    q2.add(top);
                }
            }
            else { //case 2  (q2-> q1)
                while(!q2.isEmpty()){
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;

        }

    }

    public static void main(String[] args) {
        Stack s =new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();          // output: 3 2 1
        }
    }
}
