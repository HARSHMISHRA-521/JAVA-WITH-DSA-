package CH17_BINARY_TREES;

 /*
                              1
                           /     \
                        2          3             lca for n1 = 4  & n2 =7  is 1
                     /    \     /     \          and for n1 = 4  & n2 =5 is 2
                   4       5  6         7
  */

import java.util.ArrayList;

//TC = O(n)  , only prblm is that this approach takes more space as we used two arraylist to store path
public class Last_Common_Ancestor_Approach1 {
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
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root,n1,path1);
        getPath(root,n2,path2);

        //last common ancestor
        int i=0;
        for(i=0;i< path1.size() && i<path2.size();i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        // last equal node -> i-1 th node
        Node lca = path1.get(i-1);
        return lca;
    }

    public static  boolean getPath(Node root,int n,ArrayList<Node> path){
        if(root == null){
            return false;
        }
        path.add(root);
        if(root.data == n){
            return true;
        }

        boolean foundLeft = getPath(root.left,n,path);
        boolean foundRight = getPath(root.right,n,path);

        if(foundLeft || foundRight){
            return true;
        }

        //delete the last root node
        path.remove(path.size()-1);
        return false;
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
