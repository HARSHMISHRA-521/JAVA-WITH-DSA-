package CH13_LINKEDLIST;

public class recursive_search { //sc = tc = O(n)
    class Node {
        int data;
        recursive_search.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static recursive_search.Node head;
    public static recursive_search.Node tail;

    //to add the node in first of LL
    public void addFirst(int data) {
        //step1 : create a new node
        recursive_search.Node newNode = new recursive_search.Node(data);
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
        recursive_search.Node newNode = new recursive_search.Node(data);
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
        recursive_search.Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //helper function
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx ==-1){
            return -1;
        }
        return idx +1 ;

    }

    public int recurSearch( int key){
            return helper(head , key);
        }

    public static void main(String[] args) {
        recursive_search ll = new  recursive_search();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        ll.print();  //1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        System.out.println(ll.recurSearch(6));
        System.out.println(ll.recurSearch(10));
    }

}
