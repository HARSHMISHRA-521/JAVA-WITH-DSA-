package CH18_BINARY_SEARCH_TREES;

public class Delete_BST {

    public static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data =  data;
            this.right =null;
            this.left =null;
        }
    }

    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node (val);
            return root;
        }
        if(root.data  > val ){
            //left subtree
            root.left = insert(root.left,val);
        }
        else{
            //right subtree
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static Node delete(Node root,int val){
        if(root.data<val){
            root.right =delete(root.right,val);
        }
        else if (root.data>val){
            root.left = delete(root.left,val);
        }
        else{ //root
            //case 1 : Leaf Node
            if(root.left ==null && root.right ==null){
                return null;
            }
//            case 2: one child
            if(root.left == null){
                return root.right;
            }
            else if (root.right ==null){
                return root.left;
            }

            //case 3: Both children
            Node IS = findInorderSuccessor(root.right);
            //because IS is the leftmost node of the right most subtree

            root.data =IS.data; //replace  the value of root with IS value
            root.right = delete(root.right,IS.data); // then delete the IS and update the right subtree

        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;   // leftmost node
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[]= {8,5,3,1,4,6,10,11,14};
        //       8
        //      / \
        //     5   10
        //    / \    \
       //   3   6    11
       //  / \       \
       // 1   4       14

        Node root = null;
        for(int i =0;i< values.length;i++){
            root =insert(root,values[i]);
        }
        System.out.println("Inorder sequenece before deletion : ");
        inorder(root);
        System.out.println();
        int val = 5;
        root =delete(root,val);
        System.out.println("Inorder sequence after deletion of "+val+" :");
        inorder(root);
    }

}
//output:
// Inorder sequenece before deletion :
//1 3 4 5 6 8 10 11 14

//  Inorder sequence after deletion of 10(single child case) :
//     1 3 4 5 6 8 11 14
//                     8
//                  /    \
//                5       11
//               /  \        \
//              3   6         14
//             / \
//            1   4

//    Inorder sequence after deletion of 1 ( leaf node case) :
//        3 4 5 6 8 10 11 14
//                     8
//                  /    \
//                5       10
//               /  \        \
//              3   6         11
//               \              \
//                4               14


//    Inorder sequence after deletion of 5 (two child case) :
//        1 3 4 6 8 10 11 14
//                     8
//                  /    \
//                6       10
//               /          \
//              3            11
//             /  \             \
//            1    4              14