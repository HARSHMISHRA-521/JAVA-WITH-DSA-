package CH13_LINKEDLIST;
//Question 2 :
//        Delete N Nodes After M Nodes of a Linked List
//        We have a linked list and two integers M and N. Traverse the linked list such that you retain M
//        nodes then delete next N nodes, continue the same till end of the linked list. Difficulty Level:
//        Rookie.

/*
 * Assignment_qNo2 class represents the main class for the program
 * The program deletes N nodes after M nodes in a linked list
 */

public class Assignment_qNo2 {
    /*
     * Node class represents a node in the linked list
     */
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    /*
     * Function to delete N nodes after M nodes in a linked list
     * Time Complexity: O(n) as it traverse the whole linked list
     * Space Complexity: O(1)
     */
    public static void deleteNodes(Node head, int M, int N) {
        Node current = head;

        // Traverse the linked list
        while (current != null) {
            // Skip M nodes
            for (int i = 1; i < M && current != null; i++) {
                current = current.next;
            }

            // If current is null, exit the loop
            if (current == null) {
                break;
            }

            // Delete N nodes
            Node temp = current.next;
            for (int i = 1; i <= N && temp != null; i++) {
                temp = temp.next;
            }
            current.next = temp;

            // Move current to the next node after N nodes
            current = temp;
        }
    }

    /*
     * Function to print the linked list
     */
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /*
     * Main method to test the program
     */
    public static void main(String[] args) {
        // Create a sample linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        int M = 2;
        int N = 2;

        System.out.println("Original linked list:"); // Original linked list:
                                                       //1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null
        printList(head);

        // Delete N nodes after M nodes
        deleteNodes(head, M, N);

        System.out.println("Modified linked list:");   //Modified linked list:
                                                        //  1 -> 2 -> 5 -> 6 -> null
        printList(head);
    }
}
