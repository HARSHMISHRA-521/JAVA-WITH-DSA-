package CH17_BINARY_TREES;
/*
                          1                                        27
                       /     \         (sum tree)               /     \
                    2          3           --->               9         13
                 /    \     /     \                         /   \    /     \
               4       5  6         7                     0     0    0      0
     */
public class Transform_ToSum_Tree {
    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int transform_sum(Node root){
        if(root == null){
            return 0;
        }
        int leftChild = transform_sum(root.left);
        int rightChild = transform_sum(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.left == null ? 0 : root.right.data;

                   root.data = newLeft + leftChild + newRight + rightChild;
          // eg: node 1.data =   9     +   2       +  1 3     +   3   => node 1 .data = 27

        return data; // 1 for the above example (old value of root 1 node)
    }
    public static void preorder(Node root){
        if(root == null)
            return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
          /*
                          1                                        27
                       /     \         (sum tree)               /     \
                    2          3           --->               9         13
                 /    \     /     \                         /   \    /     \
               4       5  6         7                     0     0    0      0
     */
        Node root =new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        transform_sum(root) ;
        preorder(root);
        // output : 27 9 0 0 13 0 0  (preorder traversal)
    }
}
