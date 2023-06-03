package CH13_LINKEDLIST;

public class deleteNthNode_FromEnd {
    class Node {
        int data;
        deleteNthNode_FromEnd.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static deleteNthNode_FromEnd.Node head;
    public static deleteNthNode_FromEnd.Node tail;

    //to add the node in first of LL
    public void addFirst(int data) {
        //step1 : create a new node
        deleteNthNode_FromEnd.Node newNode = new deleteNthNode_FromEnd.Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //step 2 : newNode next = head
        newNode.next = head; //link
        //step 3 : head = newNode
        head = newNode;
    }

    //to add the node at the last of LL
    public void addLast(int data) {
        deleteNthNode_FromEnd.Node newNode = new deleteNthNode_FromEnd.Node(data);
        if (head == null) {
            head = tail = null;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    //to print the LL
    public void print() {//O(n)
        if (head == null) {
            System.out.println("LL Is Empty");
            return;
        }
        deleteNthNode_FromEnd.Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void deleteNthNodeFromEnd(int n) {
        //calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (n == sz) { // n = size from end ,i.e,head from start
            head = head.next; //remove first
            return;
        }

        //sz - n
        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public static void main(String[] args) {
        deleteNthNode_FromEnd ll = new deleteNthNode_FromEnd();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        System.out.println("original LL :");
        ll.print();  //1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        ll.deleteNthNodeFromEnd(3);
        System.out.println("New LL : ");
        ll.print();

    }
}
