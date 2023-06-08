//Question 1 .
//        Intersection of Two Linked Lists
//        In a system there are two singly linked list. By some programming error, the end node of one
//        of the linked lists got linked to the second list, forming an inverted Y-shaped list. Write a
//        program to get the point where two linked lists merge.
//                   1
//       4         2
//         5     3
//           6
//           7
//        We have to find the intersection part in this system.
//
//TC : O(m*n)   && SC : O(1)

package CH13_LINKEDLIST;

public class Assignment_qNo1 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next =null;
        }
    }

    public Node getIntersectionPoint(Node head1,Node head2){
        while(head1!=null){
            Node temp =head2;
            while(temp!=null){
                if(temp==head1){
                    return head1;
                }
                temp=temp.next;
            }
            head1= head1.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Assignment_qNo1 list = new Assignment_qNo1();
        Node head1,head2;
        head1 =new Node(10);
        head2 =new Node(3);
        Node newNode = new Node(6);      //head1        head2
        head2.next = newNode;                //               3
                                             // 10          6
        newNode = new Node(6);         //        15
        head2.next.next = newNode;         //        30
                                          //        null
        newNode = new Node(15);
        head1.next = newNode;
        head2.next.next.next= newNode;

        newNode = new Node(30);
        head1.next.next =newNode;

        head1.next.next.next =null;

        Node intersectionPoint = list.getIntersectionPoint(head1,head2);
        if(intersectionPoint == null){
            System.out.println("No intersection Point\n");
        }
        else{
            System.out.println("Intersection Point: "+intersectionPoint.data);
        }

    }
}
