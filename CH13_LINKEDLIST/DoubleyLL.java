package CH13_LINKEDLIST;

public class DoubleyLL {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data= data;
            this.next =null;
            this.prev =null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add
    public void addFirst(int data){
        Node newNode =new Node(data);
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
        Node temp =head;
        System.out.print("null <-> "); //not imp
        while(temp!=null){
            System.out.print(temp.data + " <-> ");
            temp =temp.next;
        }
        System.out.println("null");
    }

    //remove
    public int removeFirst(){
        if(head == null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head= tail=null;
            size--;
            return val;
        }
        int val = head.data;
        head= head.next;
        head.prev =null;
        size--;
        return val;
    }

    public static void main(String[] args) {
        DoubleyLL dll =new DoubleyLL();
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addFirst(0);
        dll.print();
        System.out.println(dll.size);
        dll.removeFirst();
        dll.print();
        dll.removeFirst();
        dll.print();
        System.out.println(dll.size);
    }
}
