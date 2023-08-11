package CH18_BINARY_SEARCH_TREES;
/*   BST to Balanced BST
                    8
                 /      \
               6        10
              /            \
             5             11
            /                \
           3                  12
                    to ||
                      \  /

                     8
                 /      \
               5         11
              / \      /     \
             3   6    10     12
              expected BST
*/

import java.lang.reflect.Array;
import java.util.*;
public class BST_To_balancedBST {
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    static void  getInorder(Node root,ArrayList<Integer> inorder){
        if(root == null){
            return;
        }
        getInorder(root.left,inorder);
        inorder.add(root.data);
        getInorder(root.right,inorder);
    }

    static Node CreateBST(ArrayList<Integer> arr,int st,int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr.get(mid));
        root.left = CreateBST(arr,st,mid-1);
        root.right = CreateBST(arr,mid+1,end);
        return root;
    }

    static Node BalancedBSt(Node root){
        //inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root,inorder);

        //sorted inorder -> balanced BST
        root = CreateBST(inorder,0,inorder.size()-1);
        return root;
    }

    public static void main(String[] args) {
//                    8
//                 /      \
//               6        10
//              /            \
//             5             11
//            /                \
//           3                  12
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = BalancedBSt(root);
//                     8
//                 /      \
//               5         11
//              / \      /     \
//             3   6    10     12
//              expected BST
        System.out.println("The preorder sequence of BST is  :");
        preorder(root);
//        output:
//          The preorder sequence of BST is  :
//          8 5 3 6 11 10 12
    }

}
