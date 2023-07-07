package CH15_QUEUE;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumSubarray {
    /**
     * Question 5:
     * Maximum of all subarrays of size K
     * We have an array array of size N and an integer K. Find the maximum for each and every
     * contiguous subarray of size K.
     *
     * Sample Input 1: arr = [1, 2, 3, 1, 4, 5, 2, 3, 6]
     * Sample Output 1: [3, 3, 4, 5, 5, 5, 6]
     *
     * Time Complexity: O(N), where N is the size of the array
     * Space Complexity: O(K), where K is the size of the subarray and represents the maximum size of the deque
     */

    public static void findMaximumSubarray(int[] arr, int k) {
        Deque<Integer> deque = new LinkedList<>();

        // Process the first K elements separately to initialize the deque
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // Process the remaining elements of the array
        for (int i = k; i < arr.length; i++) {
            System.out.print(arr[deque.peekFirst()] + " ");

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        // Print the maximum of the last subarray
        System.out.print(arr[deque.peekFirst()]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;

        System.out.println("Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Maximum of all subarrays of size " + k + ":");
        findMaximumSubarray(arr, k);
    }
}

// Stepwise explanation of the code:
// 1. Initialize an empty deque to store indices of elements
// 2. Process the first K elements separately to initialize the deque
//    - Remove indices of elements smaller than the current element from the back of the deque
//    - Add the current index to the back of the deque
// 3. Process the remaining elements of the array
//    - Print the maximum element of the previous subarray
//    - Remove indices that are outside the current subarray's range from the front of the deque
//    - Remove indices of elements smaller than the current element from the back of the deque
//    - Add the current index to the back of the deque
// 4. Print the maximum of the last subarray

//     In more detailed way:

//Certainly! Here's a breakdown of each step in the code along with an explanation of why that step is required:
//
//        Initialize an empty deque, Deque<Integer> deque = new LinkedList<>():
//
//        We use a deque to store the indices of the array elements in a way that helps us track
//        the maximum element efficiently.
//        Process the first K elements of the array using a for loop:
//
//        This step initializes the deque with the indices of the first K elements.
//        We iterate from i = 0 to i < k and add the indices to the deque.
//        While adding the indices, we maintain the deque's property of having the maximum element at the front.
//        Process the remaining elements of the array using a for loop:
//
//        Starting from index k, we iterate over the remaining elements of the array.
//        For each iteration, we perform the following steps:
//        3.1. Print the maximum element of the previous subarray:
//
//        We print the element corresponding to arr[deque.peekFirst()], which represents
//        the maximum element of the previous subarray.
//        This element is always at the front of the deque.
//        3.2. Remove indices that are outside the current subarray's range:
//
//        We check if the index at the front of the deque (deque.peekFirst()) is less than or
//        equal to i - k.
//        If true, it means that the index is no longer within the current subarray's range, so we remove
//        it from the deque.
//        This step ensures that the deque only contains indices that belong to the current subarray.
//        3.3. Remove indices of elements smaller than the current element:
//
//        We compare the current element (arr[i]) with the elements at the back of the
//        deque (arr[deque.peekLast()]).
//        If the current element is greater than or equal to the element at the back of
//        the deque, we remove the
//        index at the back of the deque.
//        This ensures that the deque maintains a decreasing order of elements,
//        with the maximum element always at the front.
//        3.4. Add the current index to the deque:
//
//        After removing the irrelevant indices from steps 3.2 and 3.3, we add
//        the current index (i) to the back of the deque.
//        This step ensures that the deque remains updated with indices
//        corresponding to the current subarray.
//        Print the maximum of the last subarray:
//
//        After the loop completes, we print the maximum element of the last subarray,
//        which is the element at arr[deque.peekFirst()].
//        By following these steps, we can efficiently find the maximum element
//        for each contiguous subarray of size K.
