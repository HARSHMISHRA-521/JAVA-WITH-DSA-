package CH17_BINARY_TREES;

public class  Sum_Of_Nodes {  // tc : O(n)
    static class Node{
        int data;
        Node right,left;

        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return (Math.max(lh,rh)+1);
    }

    static int numbers(Node root){
        if(root == null){
            return 0;
        }

        int ln = numbers(root.left);
        int rh = numbers(root.right);
        return ln+rh+1;
    }

    static int sum(Node root){
        if(root==null){
            return 0;
        }

        int ls = sum(root.left);
        int rs = sum(root.right);
        return ls+rs+root.data;
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
        System.out.println("The sum of all the nodes is :");
        System.out.println(sum(root));
    }
}
//The height of the tree is :
//3
//The No of Nodes are :
//7
// The sum of all the nodes is :
//28
