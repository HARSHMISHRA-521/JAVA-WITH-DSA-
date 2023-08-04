package CH18_BINARY_SEARCH_TREES;

import java.util.ArrayList;

public class IsValid_BST {
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
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean IsValid(Node root, Node min, Node max){
        if(root ==null){
            return true;
        }

        if(min != null && root.data <= min.data ){
            return false;
        }
        else if(max != null && root.data >= max.data ){
            return false;
        }

        return IsValid(root.right,root,max) && IsValid(root.left , min ,root);

    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        //       8
        //      / \
        //     5   10
        //    / \    \
        //   3   6    11
        //  / \       \
        // 1   4       14

        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        System.out.println("Inorder sequence of BST  : ");
        inorder(root);
        System.out.println();

        if(IsValid(root,null,null)){
            System.out.println("VALID BST !");
        }
        else{
            System.out.println("IT IS NOT  A VALID BST !");
        }
    }
}
//output:
// Inorder sequence of BST  :
//1 3 4 5 6 8 10 11 14
//VALID BST !
