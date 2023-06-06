package CH13_LINKEDLIST;

public class reverse_DoubleLL {

    public class Node{
        int data;
        reverse_DoubleLL.Node next;
        reverse_DoubleLL.Node prev;
        public Node(int data){
            this.data= data;
            this.next =null;
            this.prev =null;
        }
    }
    public static reverse_DoubleLL.Node head;
    public static reverse_DoubleLL.Node tail;
    public static int size;

    //add
    public void addFirst(int data){
        reverse_DoubleLL.Node newNode =new reverse_DoubleLL.Node(data);
        size++;
        if(head==null){
            head= tail = newNode;
            return;
        }
        newNode.next =head;
        head.prev =newNode;
        head =newNode;
    }

    //print
    public void print(){
        reverse_DoubleLL.Node temp =head;
        System.out.print("null <-> "); //not imp
        while(temp!=null){
            System.out.print(temp.data + " <-> ");
            temp =temp.next;
        }
        System.out.println("null");
    }

    //reverse
    public void reverse(){
        Node curr =head;
        Node prev =null;
        Node next;
        while(curr!= null){
            next =curr.next;
            curr.next =prev;
            curr.prev = next;
            prev =curr;
            curr =next;
        }
        head =prev;
    }

    public static void main(String[] args) {
        reverse_DoubleLL dll =new reverse_DoubleLL();
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addFirst(0);
        dll.print();
        dll.reverse();
        dll.print();

    }
}
