//Zig-Zag Linked List
//        For a linked list of the form : ...L(1)->L(2)->L(3)->L(n-2)->L(n-1)->L(n)...
//        convert it into a zig-zag form i.e. : L(1)->L(n)->L(2)->L(n-1)->L(3)->L(n-2)...

package CH13_LINKEDLIST;

public class Zig_Zag_LL {

    static class Node {
        int data;
        Zig_Zag_LL.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static  Zig_Zag_LL .Node head;
    public static Zig_Zag_LL .Node tail;

    //to add the node in first of LL
    public void addFirst(int data) {
        //step1 : create a new node
        Zig_Zag_LL.Node newNode = new  Zig_Zag_LL.Node(data);
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
        Zig_Zag_LL.Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void zigZag(){
        //find mid
        Node slow =head;
        Node fast = head.next;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast =fast.next.next;
        }
        Node mid =slow;
        //reverse 2nd half
        Node curr =mid.next;
        mid.next =null; // for breaking LL in two halfs
        Node prev = null;
        Node next;
        while (curr !=null){
            next = curr.next;
            curr.next =prev;
            prev =curr;
            curr = next;
        }
        Node lefthead =head;
        Node righthead = prev;
        Node nextL,nextR;

        //alternate merge - zigZag merge
        while(lefthead != null && righthead !=null){
            nextL =lefthead.next;       //
            lefthead.next =righthead;   //zig zag merge
            nextR = righthead.next;     //
            righthead.next = nextL;     //

            lefthead = nextL;//updating
            righthead = nextR;//
        }
    }

    public static void main(String[] args) {
        Zig_Zag_LL ll = new Zig_Zag_LL();
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        //1->2->3->4->5->6
        ll.print();//1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        ll.zigZag();
        ll.print(); //1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null
    }

}
