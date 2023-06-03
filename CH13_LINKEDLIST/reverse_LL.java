package CH13_LINKEDLIST;
//O(n)
public class reverse_LL {
    class Node {
        int data;
        reverse_LL.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static reverse_LL.Node head;
    public static  reverse_LL.Node tail;

    //to add the node in first of LL
    public void addFirst(int data) {
        //step1 : create a new node
        reverse_LL.Node newNode = new  reverse_LL.Node(data);
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
        reverse_LL.Node newNode = new  reverse_LL.Node(data);
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
        reverse_LL.Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //reverse
    public void reverse(){
        Node prev = null;
        Node curr = tail =  head;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev =curr;
            curr = next;
        }
        head = prev;

    }
    public static void main(String[] args) {
        reverse_LL ll = new reverse_LL();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        System.out.println("original LL :");
        ll.print();  //1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
       ll.reverse();
        System.out.println("Reversed LL : ");
       ll.print();

    }


}
