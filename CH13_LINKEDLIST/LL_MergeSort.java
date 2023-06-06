package CH13_LINKEDLIST;   //O(nlog n)

public class LL_MergeSort {
    static class Node {
        int data;
        LL_MergeSort.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static  LL_MergeSort .Node head;
    public static  LL_MergeSort .Node tail;

    //to add the node in first of LL
    public void addFirst(int data) {
        //step1 : create a new node
        LL_MergeSort.Node newNode = new  LL_MergeSort.Node(data);
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
        LL_MergeSort.Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node mergeSort(Node head){
        if(head ==null || head.next == null){
            return head; //base case,i.e empty node or single node
        }
        //find mid
        Node mid =getMid(head);
        //left and right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newleft = mergeSort(head);
        Node newright = mergeSort(rightHead);

        //merge
        return merge(newleft,newright);
    }

    private Node getMid(Node head){
        Node slow =head;
        Node fast = head.next;

        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast= fast.next.next;
        }
        return slow; //mid
    }

    public Node merge(Node head1,Node head2){
        Node mergedLL = new Node(-1);
        Node temp =mergedLL;
        while(head1!= null && head2 !=null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp =temp.next;
            }else{
                temp.next =head2;
                head2 =head2.next;
                temp = temp.next;
            }
        }
        while(head1!=null){
            temp.next =head1;
            head1 = head1.next;
            temp= temp.next;
        }
        while(head2!=null){
            temp.next =head2;
            head2 = head1.next;
            temp= temp.next;
        }
        return mergedLL.next;
    }

    public static void main(String[] args) {
        LL_MergeSort ll = new LL_MergeSort();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        //5->4->3->2->1
        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();
    }
}
