package CH18_BINARY_SEARCH_TREES;
//       8
//      / \
//     5   10
//    / \    \                :paths->  8->5->3->1->null
//   3   6    11                        8->5->3->4->null
//  / \       \                         8->5->6->null
// 1   4       14                       8->10->11->14->null

import java.util.ArrayList;

public class Root2Leaf_Paths {
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

    public static void PrintRoot2Leaf(Node root, ArrayList<Integer> path){

      if(root ==null){
          return;
      }

      path.add(root.data);

      if(root.left == null && root.right == null ){
          printPath(path);
      }

      PrintRoot2Leaf(root.left,path);
      PrintRoot2Leaf(root.right,path);
      path.remove(path.size()-1); // backtrack by removing the last node of the last path
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i =0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
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
        ArrayList<Integer> path = new ArrayList<>();
        System.out.println("The possible  Root to Leaf Paths are : ");
        PrintRoot2Leaf(root,path);
    }
}
//output :
// Inorder sequence of BST  :
//1 3 4 5 6 8 10 11 14
//The possible  Root to Leaf Paths are :
//8->5->3->1->Null
//8->5->3->4->Null
//8->5->6->Null
//8->10->11->14->Null
