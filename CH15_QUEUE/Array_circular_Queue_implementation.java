package CH15_QUEUE;

public class Array_circular_Queue_implementation {
    public static class queue{
        static int arr[];
        static int size;
        static int rear;
       static int front;

        queue(int n ){
            arr = new int[n];
            size =n;
            rear = front = -1;
        }

        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        //add
        public static void add(int data){
            if(isFull()){
                System.out.println("queue is full !");
            }
            //add 1st element
            if(front == -1){
                front =0;
            }
            rear =(rear+1)%size;
            arr[rear] =data;
        }

        //remove  O(1)
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty!");
                return -1;
            }
            int result = arr[front];
            //last element
            if(rear == front ){
                rear =front = -1;
            }
            else{
                front = (front+1)%size;
            }
            return  result;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        queue q =new queue(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove());
        queue.add(4);
        System.out.println(queue.remove());
        queue.add(5);

        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();  // output :  1 2 3 4 5
        }
    }
}
