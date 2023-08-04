package CH18_BINARY_SEARCH_TREES;
/*
                     8                                                      8
                  /    \                                                  /    \
                 5      10             -> mirrored ->                   10      5
               /  \        \                                           /       /  \
            3      6         11                                      11       6     3
   */
public class Mirror_BST {
        public static class Node{
            int data;
            Node left,right;

            public Node(int data){
                this.data =  data;
                this.right =null;
                this.left =null;
            }
        }
        public static  Node CreateMirror(Node root){
            if(root == null){
                return null;
            }

            Node rightMirror = CreateMirror(root.right);
            Node leftMirror =CreateMirror(root.left);

            root.left = rightMirror;
            root.right = leftMirror;
            return root;
        }

        public static void preorder(Node root){
            if(root ==null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

    public static void main(String[] args) {
        Node root =new Node(8);
        root.left =new Node(5);
        root.right =new Node(10);
        root.left.left =new Node(3);
        root.left.right =new Node(6);
        root.right.right =new Node(11);

        root = CreateMirror(root);
        System.out.println("The preorder sequence of mirrored BST is : ");
        preorder(root);
    }
}
//output :
// The preorder sequence of mirrored BST is :
// 8 10 11 5 6 3
