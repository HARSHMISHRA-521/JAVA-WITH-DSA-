package CH14_STACK; // O(n)
import java.util.*;

// Next Greater Element
// The next greater element of some element x in an array is the first greater
// element that is to the right of x in the same array.
// arr = [6, 8, 0, 1, 3]
// next Greater = [8, -1, 1, 3, -1]

public class nextGreaterElementRight {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        int arr[] = {6, 8, 0, 1, 3};
        int nxtGreater[] = new int[arr.length];

        for (int n = arr.length - 1; n >= 0; n--) {
            // Step 1: Pop elements from the stack until a greater element is found
            while (!s.isEmpty() && arr[s.peek()] <= arr[n]) {
                s.pop();
            }

            // Step 2: Assign the next greater element to the current element
            if (s.isEmpty()) {
                nxtGreater[n] = -1;
            } else {
                nxtGreater[n] = arr[s.peek()];
            }

            // Step 3: Push the current element index into the stack
            s.push(n);
        }

        // Print the array with next greater elements
        for (int i = 0; i < nxtGreater.length; i++) {
            System.out.print(nxtGreater[i] + " ");   //output: 8 -1 1 3 -1
        }
    }
}
// Different variations of the same question could be:
// - Next Greater Right
// - Next Greater Left
// - Next Smaller Right
// - Next Smaller Left
