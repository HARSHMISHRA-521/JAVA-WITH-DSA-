package CH15_QUEUE;

public class Array_implementation {
     static class queue{
        static int size;
        static int arr[];
        static int rear;
        queue(int n){
            size= n;
            arr = new int[n];
            rear =-1;
        }

        public static boolean isEmpty(){
            return rear == -1;
        }
        //add
        public static void add(int data){
            if(rear == size-1){
                System.out.println("queue is full");
                return;
            }
            rear +=1;
            arr[rear]= data;
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty!");
                return -1;
            }
            int front = arr[0];
            for(int i =0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear-=1;
            return front;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("queue is empty!");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        queue q = new queue(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
