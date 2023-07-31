package CH17_BINARY_TREES;
import java.util.*;
public class Top_View_Of_Tree {

    public static class Node{
        Node left,right;
        int data;
        public Node(int data){
            this.data= data;
            this.right= null;
            this.left= null;
        }
    }

    public static class Info{
       Node node;
       int hd;

       public Info(Node node,int hd){
           this.node = node;
           this.hd= hd;
       }
    }

    public static void topView(Node root){

        //Level Order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map= new HashMap<>();

        int min=0,max=0;
        q.add(new Info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr== null){
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }

                if(curr.node.left !=null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min= Math.min(min,curr.hd-1);
                }

                if(curr.node.right !=null){
                    q.add(new Info(curr.node.right,curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }
        }
        for(int i = min;i<=max;i++){
            System.out.print(map.get(i).data+" ");
        }
    }

    public static void main(String[] args) {
            /*
                              1
                           /     \
                        2          3
                     /    \     /     \
                   4       5  6         7
         */
        Node root =new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The Nodes Visible from the top are : ");
        topView(root);  // output : 4  2  1  3  7
    }

}
