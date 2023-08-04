package CH18_BINARY_SEARCH_TREES;

public class Search_BST {
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

    public static boolean Search(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return Search(root.left,key);
        }
       else {
            return Search(root.right,key);
        }
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
        int val[] = {5,1,3,4,2,7};
        Node root =null;
        for(int i=0;i<val.length;i++){
            root  =insert(root,val[i]);
        }
        System.out.print("The inorder traversal of BST is : ");
        inorder(root);
        System.out.println();
        int key = 1;
        if(Search(root,key)){
            System.out.println("Found "+ key+" ! ");
        }
        else {
            System.out.println("Not found "+key+ " ! ");
        }
    }
}
//output:
// The inorder traversal of BST is : 1 2 3 4 5 7
// Not found 10 !

// The inorder traversal of BST is : 1 2 3 4 5 7
// Found 1 !
