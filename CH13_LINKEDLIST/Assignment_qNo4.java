package CH13_LINKEDLIST; //O(n)

//Question 4 :
//        Odd Even Linked List
//        We have a Linked List of integers, write a function to modify the linked list such that all even
//        numbers appear before all the odd numbers in the modified linked list. Also, keep the order of
//        even and odd numbers same.
//        Sample Input 1 : 8->12->10->5->4->1->6->NULL
//        sample Output 1 :8->12->10->4->6->5->1->NULL

public class Assignment_qNo4 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        ListNode curr = head;
        ListNode prev = null;

        // Find the original last node of the list
        while (last.next != null) {
            last = last.next;
        }

        // Store the original last node for comparison
        ListNode originalLast = last;

        // Loop through the list until we reach the last node
        while (curr != originalLast ) {

            if (curr.val % 2 != 0) {
                // If the current node is odd, we need to move it to the end of the list
                if (prev != null) {
                    // If the previous node is not null, we need to update its next pointer to skip the current node
                    prev.next = curr.next;
                } else {
                    // If the previous node is null, it means the current node is the head of the list, so we need to update the head pointer to skip the current node
                    head = curr.next;
                }
                // Now we can append the current node to the end of the list by updating the last node's next pointer
                last.next = curr;
                // We also need to update the last node to point to the current node, because it is now the new last node of the list
                last = last.next;
                // We also need to update the current node to point to its next node, because we have moved it to the end of the list
                curr = curr.next;
                // We also need to update the new last node's next pointer to null, because it is now the end of the list
                last.next = null;
            } else {
                // If the current node is even, we don't need to move it, we just update the previous and current pointers to move forward in the list
                prev = curr;
                curr = curr.next;
            }
        }

        // Check if the original last node is odd and move it to the end
        if ( curr.val % 2 != 0) {
            // If the original last node is odd, we need to move it to the end
            if (prev != null) {
                // If the previous node is not null, we need to update its next pointer to skip the original last node
                prev.next = curr.next;
            } else {
                // If the previous node is null, it means the original last node is also the head of the list, so we need to update the head pointer to skip it
                head = curr.next;
            }
            last.next = curr;
            // We also need to update the new last node to point to the original last node, because it is now the new end of the list
            last =last.next;
            last.next = null;
        }

        return head;
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(8);
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(10);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println("Original Linked List:");
        printList(head);

        ListNode modifiedHead = oddEvenList(head);

        System.out.println("Modified Linked List:");
        printList(modifiedHead);
    }
}
