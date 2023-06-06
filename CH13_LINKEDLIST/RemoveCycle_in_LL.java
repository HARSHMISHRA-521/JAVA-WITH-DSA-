package CH13_LINKEDLIST;

public class RemoveCycle_in_LL {
    static class Node {
        int data;
        RemoveCycle_in_LL.Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static  RemoveCycle_in_LL .Node head;
    public static  RemoveCycle_in_LL .Node tail;

    public static boolean isCycle(){  //Floyd's Cycle Finding Algo
        RemoveCycle_in_LL.Node slow = head;
        RemoveCycle_in_LL.Node fast =head;
        while(fast != null && fast.next != null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
            if(slow == fast){
                return true;//cycle exists
            }
        }
        return false;//cycle doesn't exists
    }

    public static void removeCycle(){

        //detect cycle
        Node fast = head;
        Node slow =head;
        boolean cycle =false; //flag
        while(fast!=null && fast.next!=null){
            slow =slow.next;//+1
            fast=fast.next.next;//+2
            if(slow==fast){ //cycle exists
                cycle= true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        //finding meeting point
        slow =head;
        Node prev =null; //for storing last node
        while(slow!= fast){
            prev= fast;
            slow =slow.next;//+1
            fast= fast.next;//+1
        }

        //remove cycle -> last.next =null
        prev.next =null;
    }

    public static void main(String[] args) {
        head =new Node(1);
        Node temp = new Node(2);
        head.next =temp;
        head.next.next =new Node(3);
        head.next.next.next = temp;
        //1->2->3->2
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }

}
