package CH17_BINARY_TREES;
/*
                              1
                           /     \
                        2          3             min dist btw n1 = 4 and n2 = 7 is 4
                     /    \     /     \          and for n1 = 4  & n2 =5 is 2
                   4       5  6         7
  */


public class Min_Dist_Btw_Two_Nodes { // O(n)
    public static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data =data;
            this.left = null;
            this.right =null;
        }
    }

    public static Node lca(Node root,int n1,int n2){
        if(root==null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftlca = lca(root.left,n1,n2);
        Node rightlca= lca(root.right,n1,n2);

        if(leftlca == null){
            return rightlca;
        }
        if(rightlca == null){
            return leftlca;
        }
        //if both are not null then
        return root;
    }

    public static int minDist(Node root,int n1,int n2){
        Node lca = lca(root,n1,n2);
        int dist1 = lcaDist(lca,n1);
        int dist2 = lcaDist(lca,n2);

        return dist1+dist2;
    }
    public static int  lcaDist(Node root,int n){
        if(root == null){
            return -1;
        }
        if(root.data==n){
            return 0; // distance from the root node is 0
        }
        int leftDist = lcaDist(root.left,n);
        int rightDist = lcaDist(root.right,n);

        if(leftDist==-1 && rightDist ==-1) {   // if both left and right dist are -1
            return -1;
        }
        else if(leftDist == -1){
            return rightDist+1;
        }
        else {  //if(rightDist == -1)
            return leftDist+1;
        }
    }

    public static void main(String[] args) {
           /*
                              1
                           /     \
                        2          3
                     /    \     /     \
                   4       5  6         7
         */
        Node root =new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.print("The min distance between two nodes are  : "+" ");
        System.out.print(minDist(root,4,6));
        // output : The min distance between two nodes are  :  4
    }
}
