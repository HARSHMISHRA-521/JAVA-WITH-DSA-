package CH17_BINARY_TREES;
//TC : O(n)
public class Build_Tree_Preorder {
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
        public static void preorder(Node root){
            if(root==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTrees(nodes);
        System.out.print("The root node is : ");
        System.out.print(" "+root.data);
        System.out.println();
        tree.preorder(root);  //1 2 4 5 3 6
    }
}
//The root node is :   1

//      1
//     / \
//    2   3
//   /     \
//  4       6
//   \
//    5