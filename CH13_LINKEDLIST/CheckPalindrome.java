package CH13_LINKEDLIST;

public class CheckPalindrome {

    class Node {
        int data;
        CheckPalindrome .Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static CheckPalindrome .Node head;
    public static CheckPalindrome .Node tail;

    //to add the node in first of LL
    public void addFirst(int data) {
        //step1 : create a new node
        CheckPalindrome .Node newNode = new CheckPalindrome .Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //step 2 : newNode next = head
        newNode.next = head; //link
        //step 3 : head = newNode
        head = newNode;
    }

    //to print the LL
    public void print() {//O(n)
        if (head == null) {
            System.out.println("LL Is Empty");
            return;
        }
        CheckPalindrome .Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //slow-fast approach
    public static Node findMid(Node head){ //helper
        Node slow =head;
        Node fast = head;
        while(fast!=null && fast.next!= null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
        }
        return slow; // slow is my mid node
    }

    //check palindrome
    public boolean checkPalindrome(){
        //base case and corner case
        if(head == null || head.next ==null){
            return true;
        }
        //step 1 -find mid
        Node midNode = findMid(head);

        //step 2 -reverse second half
        Node prev =null;
        Node curr = midNode;
        Node next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }

        Node right = prev; // right half's head
        Node left = head; //left half's head

        //step 3 - check left half and right half
        while(right!= null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right=right.next;
        }
        return true;
    }
    public static void main(String[] args) {
        CheckPalindrome ll = new   CheckPalindrome();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(2);
        ll.addFirst(1);



        System.out.println(" LL is :");
        ll.print();  //1 -> 2 -> 2 -> 1 -> null
        System.out.println(ll.checkPalindrome());


    }

}
