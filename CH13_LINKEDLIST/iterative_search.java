package CH13_LINKEDLIST;

public class iterative_search { //O(n)
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    //to add the node in first of LL
    public void addFirst(int data){
        //step1 : create a new node
        Node newNode = new Node(data);
        if(head == null){
            head  = tail=newNode;
            return;
        }
        //step 2 : newNode next = head
        newNode.next = head; //link
        //step 3 : head = newNode
        head = newNode;
    }

    //to add the node at the last of LL
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = null;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    //to print the LL
    public void print(){//O(n)
        if(head == null){
            System.out.println("LL Is Empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    //iterative search
    public int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {// key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }

    public static void main(String[] args) {
        iterative_search ll = new iterative_search();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.print();  //1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        System.out.println(ll.itrSearch(6));
        System.out.println(ll.itrSearch(10));
    }
}
