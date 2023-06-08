package CH13_LINKEDLIST; // O(kn log k)
// Question: We have K sorted linked lists of size N each, merge them and print the sorted output.

// Time complexity: O(kn log k), where k is the number of lists and n is the length of the longest list in the array.
// Explanation: The main idea of the code is to merge the k lists in pairs until there is only one list left.
// This means that in each iteration, we merge k/2 pairs of lists, and each pair takes O(n) time to merge,
// where n is the length of the longer list in the pair.
// Therefore, the total time for one iteration is O(kn). Since we repeat this process log(k) times until
// there is only one list left, the total time complexity is O(kn log k).



// Define a class for the assignment question 5
public class Assignment_qNo5 {
    // Define a class for a linked list node
    class ListNode {
        // Declare the value and the next pointer of the node
        int val;
        ListNode next;

        // Constructor to initialize the node with a value and a next pointer
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Define a function to merge two sorted linked lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy head for the merged list
        ListNode dummy = new ListNode(0, null);
        // Create a pointer to track the current node of the merged list
        ListNode curr = dummy;
        // Loop until both lists are exhausted
        while (l1 != null && l2 != null) {
            // Compare the values of the two lists and append the smaller one to the merged list
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            // Move the current pointer to the next node of the merged list
            curr = curr.next;
        }
        // Append the remaining nodes of either list to the merged list
        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }
        // Return the head of the merged list, skipping the dummy node
        return dummy.next;
    }

    // Define a function to merge k sorted linked lists
    public ListNode mergeKLists(ListNode[] lists) {
        // Check if the input array is empty or null
        if (lists == null || lists.length == 0) {
            return null;
        }
        // Initialize a variable to store the number of lists
        int k = lists.length;
        // Loop until there is only one list left in the array
        while (k > 1) {
            // Initialize two pointers to track the start and end of the array
            int i = 0;
            int j = k - 1;
            // Loop until the start and end pointers meet or cross each other
            while (i < j) {
                // Merge the ith and jth lists and store the result in the ith position
                lists[i] = mergeTwoLists(lists[i], lists[j]);
                // Increment the start pointer and decrement the end pointer
                i++;
                j--;
            }
            // Update the number of lists to half of its previous value, rounding up if odd
            k = (k + 1) / 2;
        }
        // Return the only remaining list in the array, which is the final merged list
        return lists[0];
    }

    // Define a main function to test the code with some sample input and output
    public static void main(String[] args) {
        // Create an object of Assignment_qNo5 class
        Assignment_qNo5 obj = new Assignment_qNo5();

        // Create some sample linked lists for testing
        ListNode l1 = obj.new ListNode(1, obj.new ListNode(4, obj.new ListNode(5, null)));
        ListNode l2 = obj.new ListNode(1, obj.new ListNode(3, obj.new ListNode(4, null)));
        ListNode l3 = obj.new ListNode(2, obj.new ListNode(6, null));

        // Store them in an array
        ListNode[] lists = {l1, l2, l3};

        // Call the mergeKLists function and store the result in a variable
        ListNode result = obj.mergeKLists(lists);

        // Print the result by traversing the linked list
        System.out.print("The merged sorted list is: ");
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");   //The merged sorted list is: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> null

    }
}