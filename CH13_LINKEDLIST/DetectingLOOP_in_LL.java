package CH13_LINKEDLIST;

public class DetectingLOOP_in_LL {

    static class Node {
        int data;
        DetectingLOOP_in_LL.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static DetectingLOOP_in_LL .Node head;
    public static DetectingLOOP_in_LL .Node tail;

    public static boolean isCycle(){  //Floyd's Cycle Finding Algo
        Node slow = head;
        Node fast =head;
        while(fast != null && fast.next != null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
            if(slow == fast){
                return true;//cycle exists
            }
        }
        return false;//cycle doesn't exists
    }

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
         //1->2->3->1
        System.out.println(isCycle());
    }
}
