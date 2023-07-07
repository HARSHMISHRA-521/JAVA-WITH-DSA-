package CH15_QUEUE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElementsOfQueue {
    /**
     * Question 4:
     * Reversing the first K elements of a Queue
     * We have an integer k and a queue of integers, we need to reverse the order of the first k
     * elements of the queue, leaving the others in the same relative order.
     *
     * Sample Input 1: Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
     * Sample Output 1: Q = [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]
     *
     * Time Complexity: O(N), where N is the size of the queue
     * Space Complexity: O(K), where K is the number of elements to be reversed
     */

    /*  Also note:
     * remove(): The remove() method removes and returns the head of the queue. If the queue is empty, it throws a NoSuchElementException immediately.
     *
     * poll(): The poll() method removes and returns the head of the queue. If the queue is empty, it returns null without throwing an exception.
     */

    public static void reverseKElements(Queue<Integer> queue, int k) {
        Queue<Integer> reversedElements = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        // Push the first K elements from the queue into the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Add the reversed elements to a separate queue
        while (!stack.isEmpty()) {
            reversedElements.add(stack.pop());
        }

        // Add the remaining elements from the original queue to the new queue
        while (!queue.isEmpty()) {
            reversedElements.add(queue.poll());
        }

        // Assign the reversed elements back to the original queue
        queue.clear();
        queue.addAll(reversedElements);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);

        int k = 5;

        System.out.println("Original Queue: " + queue);

        reverseKElements(queue, k);

        System.out.println("Modified Queue: " + queue);
    }
}
