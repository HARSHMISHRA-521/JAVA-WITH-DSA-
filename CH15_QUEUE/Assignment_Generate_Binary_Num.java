package CH15_QUEUE; //TC = SC = O(n)
//Question 1 .
//        Generate Binary Numbers
//        Given a number N. The task is to generate and print all binary numbers with decimal values from
//        1 to N.
//        Sample Input 1 : N =2
//        Sample Output 1 : 1 10
//        Sample Input 2
//        Sample Output 2
//        : 1 10 11 100 101

import java.util.*;

public class Assignment_Generate_Binary_Num  {
    // Function to generate and print binary numbers from 1 to n
    static void generatePrintBinary(int n) {
        Queue<String> queue = new LinkedList<String>();
        queue.add("1"); // Start with the binary number "1"

        // Iterate until the desired count is reached
        while (n > 0) {
            String s = queue.remove(); // Retrieve the front element from the queue

            System.out.println(s); // Print the binary number

            String s1 = s + "0"; // Append "0" to the binary number
            String s2 = s + "1"; // Append "1" to the binary number

            queue.add(s1); // Add the newly generated binary number to the queue
            queue.add(s2); // Add the newly generated binary number to the queue

            n--; // Decrement the count
        }
    }

    public static void main(String[] args) {
        int n = 10; // Generate binary numbers from 1 to 10
        generatePrintBinary(n);
    }
}

//    We define a function generatePrintBinary that takes an integer n as input, which represents the count of binary
//        numbers to be generated and printed.
//        We create a queue queue of strings to store the binary numbers.
//        We add the starting binary number "1" to the queue.
//        We enter a loop that continues until the count n becomes zero.
//        Inside the loop, we retrieve the front element from the queue using the remove method and store it in the
//        string variable s.
//        We print the value of s, which represents the current binary number.
//        We generate two new binary numbers by appending "0" and "1" to the current binary number s, and store them
//        in strings s1 and s2, respectively.
//        We add the newly generated binary numbers s1 and s2 to the queue.
//        We decrement the count n by 1.
//        The loop continues until the desired count is reached, generating and printing binary numbers from 1 to n.
//        The code follows a breadth-first search (BFS) approach, where we generate binary numbers in a level-by-level
//        manner. Starting with the binary number "1", we generate two new binary numbers by appending "0" and "1".
//        These new numbers become the next level of the BFS. By iterating and expanding the queue, we generate and
//        print binary numbers from 1 to n.