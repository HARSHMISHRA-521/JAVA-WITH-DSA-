package CH18_BINARY_SEARCH_TREES;
/*Size of Largest BST in BT
                    50
                 /      \
               30         60
              / \      /     \
             5   20   45     70
                     /         \
                    65           80

                    gives =>
                           60
                        /     \
                      45       70
                     /           \
                    65            80
                    size is : 5
*/
public class Size_Of_LargestBST_In_BT {
    public static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static class Info{
        boolean isBst;
        int size;
        int max;
        int min;

        public Info(boolean isBst,int size,int min,int max){
            this.isBst = isBst;
            this.size = size;
            this.min= min;
            this.max= max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root){

        if(root == null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        Info left = largestBST(root.left);
        Info right = largestBST(root.right);
        int size = left.size + right.size + 1;
        int min  = Math.min(root.data,Math.min(left.min,right.min));
        int max  = Math.max(root.data,Math.max(left.max,right.max));

        if(root.data <= left.max || root.data >= right.min){
            return new Info(false,size,min,max);
        }

        if(left.isBst && right.isBst){
            maxBST = Math.max(maxBST,size);
            return new Info(true,size,min,max);
        }

        return new Info(false,size,min,max);
    }

    public static void main(String[] args) {
//                    50
//                 /      \
//               30         60
//              / \      /     \
//             5   20   45     70
//                           /    \
//                          65     80
        Node root = new Node(50);

        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        Info info = largestBST(root);
//                           60
//                        /     \
//                      45       70
//                             /   \
//                           65     80
//                   expected output =>  size of largest  BST  is : 5

        System.out.println("Largest BST size is : "+maxBST);
    }
}
//Largest BST size is : 5
