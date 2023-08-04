package CH18_BINARY_SEARCH_TREES;

public class BUILD_BST {

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
        if (root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            //left subtree
            root.left = insert(root.left,val);
        }
        else{
            //right subtree
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int val[] ={5,1,3,4,2,7};
        Node root =null;
        for(int i= 0;i<val.length;i++){
            root =insert(root,val[i]);
        }

        inorder(root);
        // output : 1 2 3 4 5 7
    }
}
