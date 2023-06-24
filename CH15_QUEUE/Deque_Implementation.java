package CH15_QUEUE;
//Deque : Double ended queue ->we can add or remove from both the ends
//        methods:
//                addFirst( )
//                addLast( )
//                removeFirst( )
//                removeLast( )
//                getFirst( )
//                getLast( )


//** remember : "DEQUEUE" means removal or deletion
import java.util.Deque;
import java.util.LinkedList;

public class Deque_Implementation  {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        // Adding elements to the deque
        deque.addFirst("First");
        deque.addLast("Last");
        deque.addFirst("New First");

        System.out.println("Deque after adding elements: " + deque);

        // Removing elements from the deque
        String removedFirst = deque.removeFirst();
        String removedLast = deque.removeLast();

        System.out.println("Removed first element: " + removedFirst);
        System.out.println("Removed last element: " + removedLast);

        System.out.println("Deque after removing elements: " + deque);

        // Getting the first and last elements from the deque
        String firstElement = deque.getFirst();
        String lastElement = deque.getLast();

        System.out.println("First element: " + firstElement);
        System.out.println("Last element: " + lastElement);
    }
}

//    Deque after adding elements: [New First, First, Last]

//                 +-------------+
//        Front -> | New First   |
//                 +-------------+
//                 | First       |
//                 +-------------+
//                 | Last        |
//                 +-------------+
//                 |             |
//                 |             |
//        Rear  -> |             |
//                 +-------------+
