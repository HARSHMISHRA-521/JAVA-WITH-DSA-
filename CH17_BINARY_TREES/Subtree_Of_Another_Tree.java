package CH17_BINARY_TREES;

public class Subtree_Of_Another_Tree {
    static class Node{
        int data;
        Node right,left;

        Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
    }

    public static boolean isSubtree(Node root,Node subRoot){
        if(root == null){
            return false;
        }
        if(root.data== subRoot.data){
            if(isIdentical(root,subRoot)){
                return true;
            }
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public static  boolean isIdentical(Node node,Node subRoot){
        if(node==null && subRoot == null){
            return true;
        }
        else if(node ==null || subRoot == null || node.data!= subRoot.data){
            return false;
        }
        if(!isIdentical(node.left,subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right,subRoot.right)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*
                              1
                           /     \
                        2          3
                     /    \     /     \
                     4    5    6       7
         */
        Node root =new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*
                              2
                             /  \
                             4   5
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        System.out.println(isSubtree(root,subRoot));  // true
    }

}
