package CH17_BINARY_TREES;

public class  Diameter_Tree_Approach1 {  // tc : O(n ^ 2 )
    static class Node{
        int data;
        Node right,left;

        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    static int height(Node root){   // O(n)
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return (Math.max(lh,rh)+1);
    }

    static int numbers(Node root){  //O(n)
        if(root == null){
            return 0;
        }

        int ln = numbers(root.left);
        int rh = numbers(root.right);
        return ln+rh+1;
    }
    static int Diameter(Node root){   // O(n^2)
        if(root==null){
            return 0;
        }
        int ldim= Diameter(root.left);
        int rdim= Diameter(root.right);
        int lh= height(root.left);
        int rh= height(root.right);
        int selfdim = lh+rh+1;

        return Math.max(Math.max(ldim,rdim),selfdim);
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
        System.out.println(height(root));
        System.out.println("The No of Nodes are : ");
        System.out.println(numbers(root));
        System.out.println("The diameter of the tree is : ");
        System.out.println(Diameter(root));
    }
}
//The height of the tree is :
//3
//The No of Nodes are :
//7
// The diameter of the tree is :
//5
