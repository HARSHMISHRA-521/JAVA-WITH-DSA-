package CH17_BINARY_TREES;
/*
                              1
                           /     \
                        2          3            Kth ancestor of   n = 4 and kth = 1 is  node 2
                     /    \     /     \          and for n= 4  & kth =2  is node 1
                   4       5  6         7
  */

public class Kth_Ancestor {
    public static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data =data;
            this.left = null;
            this.right =null;
        }
    }

    public static int Kancestor(Node root,int n ,int k){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int leftDist = Kancestor(root.left,n,k);
        int rightDist = Kancestor(root.right,n,k);

        if(rightDist == -1 && leftDist ==-1){
            return -1;
        }
        int max = Math.max(rightDist,leftDist);//as max will quickly return the valid dist as one dist will be valid
        if(max+1 == k){                        // and other one will be definetly -1
            System.out.println("The "+k+"th ancestor of node "+
                    n+" is : "+root.data);
        }
        return max+1;
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

        Kancestor(root,5,2) ;
        // output : The 2th ancestor of node 5 is : 1
    }
}
