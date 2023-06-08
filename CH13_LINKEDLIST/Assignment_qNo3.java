//Question 3 :
//        Swapping Nodes in a Linked List
//        We have a linked list and two keys in it, swap nodes for t.N'0 given keys. Nodes should be
//        swapped by changing links. Swapping data of nodes may be expensive in many situations when
//        data contains many fields. It may be assumed that all keys in the linked list are distinct.
//        Sample Input 1 : 1->2->3->4 x = 2, y = 4
//        Sample Output 1 : 1->4->3->2

// Solution 3:
// Time Complexity: O(n)
// Space Complexity: O(1)

package CH13_LINKEDLIST;
class Assignment_qNo3 {
    // Node class representing a single node in the linked list
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head; // Reference to the head node of the linked list

    // Method to swap two nodes with data values x and y
    public void swapNodes(int x, int y) {
        // If x and y are the same, no need to swap
        if (x == y)
            return;

        Node prevX = null, currX = head;
        // Search for node with data x and keep track of previous node
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        // Search for node with data y and keep track of previous node
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not found, no swap is possible
        if (currX == null || currY == null)
            return;

        // If x is not the head of the list, update the next of previous node of x
        if (prevX != null)
            prevX.next = currY;
        else
            head = currY;

        // If y is not the head of the list, update the next of previous node of y
        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;

        // Swap the next pointers of x and y nodes
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    // Method to insert a new node at the beginning of the linked list
    public void push(int new_data) {
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        head = new_Node;
    }

    // Method to print the linked list
    public void printList() {
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Assignment_qNo3 list = new Assignment_qNo3();
        list.push(7);
        list.push(6);
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
        list.push(0);

        System.out.print("Linked list before swapping: ");
        list.printList();

        list.swapNodes(4, 3);

        System.out.print("Linked list after swapping: ");
        list.printList();
    }
}
