package CH15_QUEUE;   // Tc =  O(N * logN)
                     // Sc = O(n)
 /*
    Question:
    Connect n ropes with minimum cost.
    Given are N ropes of different lengths, the task is to connect these ropes into one rope with minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.

    Sample Input 1: N = 4, arr = [4, 3, 2, 6]
    Sample Output 1: 29

    Sample Input 2: N = 2, arr = [1, 2, 3]
    Sample Output 2: 9
    */

import java.util.PriorityQueue;

public class Assignment_Min_cost_ropes_prblm  {
    public static int connectRopes(int[] arr) {
        // Create a priority queue to store the rope lengths
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all the rope lengths to the priority queue
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        int totalCost = 0;

        // Repeat the process until there is only one rope left
        while (minHeap.size() > 1) {
            // Remove the two shortest ropes from the queue
            int rope1 = minHeap.poll();
            int rope2 = minHeap.poll();

            // Connect the two ropes and calculate the cost
            int newRope = rope1 + rope2;
            totalCost += newRope;

            // Add the new rope back to the queue
            minHeap.add(newRope);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 3, 2, 6};
        int cost1 = connectRopes(arr1);
        System.out.println("Sample Output 1: " + cost1); // Output: 29

        int[] arr2 = {1, 2, 3};
        int cost2 = connectRopes(arr2);
        System.out.println("Sample Output 2: " + cost2); // Output: 9
    }

    // Approach to the question of connecting ropes with minimum cost using a PriorityQueue:
    /*
    1. Create a PriorityQueue named minHeap to store the rope lengths. This will be used to efficiently retrieve the two shortest ropes at each step.
    2. Add all the rope lengths to the minHeap using the add() method.
    3. Initialize a variable totalCost to keep track of the total cost of connecting the ropes.
    4. Enter a loop that continues until there is only one rope left in the minHeap.
    5. Within the loop, remove the two shortest ropes from the minHeap using the poll() method. The poll() method removes and returns the smallest element from the queue.
    6. Connect the two ropes by summing their lengths and store the result in newRope.
    7. Add the newRope back to the minHeap using the add() method to be considered in the next iteration.
    8. Update the totalCost by adding the length of the newRope.
    9. Once the loop ends, all the ropes have been connected into a single rope, and the minHeap contains only one element, which is the final rope.
    10. Return the totalCost, which represents the minimum cost of connecting all the ropes.
    */

     /*
    Time Complexity:
    - Adding all the rope lengths to the priority queue takes O(N * logN) time, where N is the number of ropes.
    - The while loop iterates N-1 times since we connect two ropes in each iteration until only one rope is left.
      - Removing the two shortest ropes from the priority queue using the poll() method takes O(logN) time.
      - Calculating the new rope length and updating the total cost takes constant time, O(1).
      - Adding the new rope length back to the priority queue takes O(logN) time.
    - Overall, the dominant factor in terms of time complexity is the insertion and removal operations on the priority queue.
      Therefore, the time complexity of the code is O(N * logN).

    Space Complexity:
    - The space complexity of the code is O(N), where N is the number of ropes.
      - The priority queue stores the rope lengths, and in the worst case, it can store all the N rope lengths.
      - Additional variables used, such as totalCost and the loop variables, require constant space, O(1).
    - It's important to note that the space complexity does not include the space required to store the input and output of the function,
      as it is assumed to be part of the function's interface.
    */

    // Explanation of PriorityQueue and its methods:
    /*
    - PriorityQueue is a class in Java that represents a priority queue. It is implemented as a heap data structure.
    - By default, PriorityQueue uses the natural ordering of elements to determine their priority. The smallest element (according to the natural ordering) is always at the front of the queue.
    - You can also provide a custom Comparator to the PriorityQueue constructor to define a different ordering or priority criteria for the elements.
    - The key methods of PriorityQueue are:
      - add(E element): Adds the specified element to the queue.
      - poll(): Retrieves and removes the head of the queue (the smallest element).
      - peek(): Retrieves, but does not remove, the head of the queue.
    - When you add elements to a PriorityQueue, they are automatically sorted based on their priority. The element with the highest priority (smallest value) is at the front of the queue.
    - The poll() method removes and returns the head of the queue. It retrieves the smallest element and maintains the heap property of the queue.
    - The peek() method retrieves, but does not remove, the head of the queue. It allows you to examine the smallest element without modifying the queue.
    - The PriorityQueue class also provides other methods for manipulating and querying the queue, such as size(), isEmpty(), and clear().
    - When using a PriorityQueue with a custom Comparator, the ordering of elements is determined by the comparison logic defined in the Comparator implementation.
    - By utilizing the PriorityQueue data structure and its methods, we can efficiently retrieve the two shortest ropes at each step, ensuring an optimal solution to the problem of connecting ropes with minimum cost.
    */
}
