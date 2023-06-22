package CH15_QUEUE;

public class Linked_List_Implementation {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data =data;
            this.next= null;
        }
    }
    static class queue{
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty(){
            return head ==null & tail ==null;
        }

        //add O(n)
        public static void add(int data){
            Node newNode = new Node(data);
            if(head ==null){
                head= tail = newNode;
            }
            tail.next =newNode;
            tail =newNode;
        }

        //remove O(n)
        public static int remove(){
            if (isEmpty()){
                System.out.println("Queue is empty ");
                return -1;
            }
            int front = head.data;
            //single element
            if(tail == head){
                tail = head= null;
            }
            else{
                head = head.next;
            }
            return front;
        }

        //peek O(n)
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty !");
                return -1;
            }
            return  head.data;
        }
    }

    public static void main(String[] args) {
        queue q =  new queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();  // 1 2 3
        }
    }

}
