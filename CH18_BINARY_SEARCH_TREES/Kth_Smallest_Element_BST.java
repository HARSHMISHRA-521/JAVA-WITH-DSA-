package CH18_BINARY_SEARCH_TREES;
/*
230. Kth Smallest Element in a BST :
Given the root of a binary search tree, and an integer k , return the kth smallest value (I-indexed) of all the values of the
nodes in the tree.
 */
import java.util.*;
public class Kth_Smallest_Element_BST {

     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        getInorder(root,list);
        return list.get(k-1);
    }

    public void  getInorder(TreeNode root ,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        getInorder(root.left,list);
        list.add(root.val);
        getInorder(root.right,list);
    }
}
