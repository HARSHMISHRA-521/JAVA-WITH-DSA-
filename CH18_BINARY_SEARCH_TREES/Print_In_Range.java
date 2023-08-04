package CH18_BINARY_SEARCH_TREES;

public class Print_In_Range {
    public static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data =  data;
            this.right =null;
            this.left =null;
        }
    }

    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node (val);
            return root;
        }
        if(root.data  > val ){
            //left subtree
            root.left = insert(root.left,val);
        }
        else{
            //right subtree
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static void print(Node root,int r1,int r2){
        if(root ==null){
            return;
        }
        if(root.data>= r1 && root.data<= r2){
            print(root.left,r1,r2);
            System.out.print(root.data+" ");
            print(root.right,r1,r2);
        }

        else if (root.data < r1){
            print(root.left,r1,r2);
        }
        else {  //(root.data > r2)
            print(root.right,r1,r2);
        }
    }

    public static void main(String[] args) {
        int values[]= {8,5,3,1,4,6,10,11,14};
        //       8
        //      / \
        //     5   10
        //    / \    \
        //   3   6    11
        //  / \       \
        // 1   4       14

        Node root = null;
        for(int i =0;i< values.length;i++){
            root =insert(root,values[i]);
        }

        print(root,5,12);  // output: 5 6 8 10 11
    }
}
