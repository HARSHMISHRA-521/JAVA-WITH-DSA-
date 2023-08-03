package CH17_BINARY_TREES;

 /*
                              1
                           /     \
                        2          3             lca for n1 = 4  & n2 =7  is 1
                     /    \     /     \          and for n1 = 4  & n2 =5 is 2
                   4       5  6         7
  */

//TC = O(n)  , SC = O(n) in this we only used space of stack for recursion and no other auxillary data structure

public class Last_Common_Ancestor_Approach2 {
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right =null;
        }
    }

    public static Node lca(Node root,int n1,int n2){
       if(root == null || root.data == n1 || root.data == n2){
           return root;
       }

       Node leftLCA = lca(root.left,n1,n2);
       Node rightLCA = lca(root.right,n1,n2);

       if(leftLCA==null){
           return rightLCA;
       }
       if(rightLCA == null){
           return leftLCA;
       }

       //if both are not null then
        return root;
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

        System.out.print("The Last common ancestor is  : "+" ");
        System.out.print(lca(root,5,6).data);  // output : The Last common ancestor is  :  1
    }
}
