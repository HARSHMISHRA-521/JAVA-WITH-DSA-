package CH17_BINARY_TREES;

public class  Diameter_Tree_Approach2 {  // tc : O(n)
    static class Node{
        int data;
        Node right,left;

        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    static class Info{
        int dim;
        int ht;

        public Info(int dim,int ht){
            this.dim= dim;
            this.ht= ht;
        }
    }

    static Info Diameter(Node root){   // O(n)
        if(root==null){
            return new Info(0,0);
        }

       Info leftinfo= Diameter(root.left);
       Info rightinfo= Diameter(root.right);

       int dim = Math.max(Math.max(leftinfo.dim,rightinfo.dim),leftinfo.ht+ rightinfo.ht+1);
       int ht = Math.max(leftinfo.ht, rightinfo.ht)+1;

       return  new Info(dim,ht);
    }

    public static void main(String[] args) {
        /*
                        1
                      /   \
                    2       3
                  /  \    /   \
                4    5   6     7
         */
        Node root =new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The height of the tree is : ");
        System.out.println(Diameter(root).ht);
        System.out.println("The diameter of the tree is : ");
        System.out.println(Diameter(root).dim);
    }
}
//The height of the tree is :
//3
// The diameter of the tree is :
//5
