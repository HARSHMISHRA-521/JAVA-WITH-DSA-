package CH14_STACK;  // O(n)

//The time complexity of the isPalindrome function in the given implementation
//        is O(n), where n is the number
//        of nodes in the linked list.
//
//        The function iterates through the linked list to push the
//        first half (or right half in case of even length) of the characters
//        onto the stack, which takes O(n/2) time. Then, it compares the remaining
//        elements with the popped elements from the stack, which again takes O(n/2) time.
//
//        Overall, the time complexity is O(n/2) + O(n/2), which simplifies to O(n).
//        Thus, the time complexity of the isPalindrome function is linear with respect
//        to the number of nodes in the linked list.

//Q: Palindrome Linked List
//        We have a singly linked list of characters, write a function that returns true if the given list is a
//        palindrome, else false.
//        Input : A->B->C->B->A
//        Output: Yes It is Palindrome

import java.util.Stack;

// Palindrome Linked List using Stacks
public class PlaindromeLinkedList_byStacks {

    // Definition of a node in the linked list
    static class ListNode {
        char val;
        ListNode next;

        ListNode(char val) {
            this.val = val;
        }
    }

    // Function to check if the linked list is a palindrome
    public static boolean isPalindrome(ListNode head) {
        // Empty list or single element is considered a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;

        // Push elements till the middle (or right middle in case of even length) of the linked list onto the stack
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;  //+1
            fast = fast.next.next; //+2
        }

        // If the length of the linked list is odd, skip the middle element
        if (fast != null) {
            slow = slow.next;
        }

        // Compare the remaining elements with the popped elements from the stack
        while (slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }

        // If all elements match, the linked list is a palindrome
        return true;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode A = new ListNode('A');
        ListNode B1 = new ListNode('B');
        ListNode C = new ListNode('C');
        ListNode B2 = new ListNode('B');
        ListNode A2 = new ListNode('A');

        A.next = B1;
        B1.next = C;
        C.next = B2;
        B2.next = A2;

        if (isPalindrome(A)) {
            System.out.println("Yes, it is a palindrome.");
        } else {
            System.out.println("No, it is not a palindrome.");
        }
    }
}

