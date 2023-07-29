package CH17_BINARY_TREES;
import java.util.*;
public class Build_Tree_Level_Order {
    static  class Node{
        int data;
         Node left;
         Node right;

        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    static class BinaryTree{
        static int idx =-1;
        public static Node buildTrees(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTrees(nodes);
            newNode.right= buildTrees(nodes);
            return newNode;
        }
        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node curr = q.remove();
                if (curr == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }else{
                    System.out.print(curr.data+" ");
                    if(curr.left!=null){
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
         BinaryTree tree = new BinaryTree();
         Node root = tree.buildTrees(nodes);
        System.out.print("The root node is : ");
        System.out.print(" "+root.data);
        System.out.println();
        tree.levelorder(root);  //  1
                              //   2  3
                              //   4  5   6
    }
}
//The root node is :   1

//       1
//     /  \
//    2    3
//   / \     \
//  4   5    6
