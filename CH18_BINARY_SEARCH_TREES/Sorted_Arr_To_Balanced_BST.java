package CH18_BINARY_SEARCH_TREES;
/*   Sorted array to Balanced BST
      arr =  {3,  5,6, 8, 10, 11, 12}

                     8
                 /      \
               5         11
              / \      /     \
             3   6    10     11
              expected BST
*/
public class Sorted_Arr_To_Balanced_BST {  // O(n)
    static class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    static Node CreateBST(int arr[],int st,int end){
        if(st>end){
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = CreateBST(arr,st,mid-1);
        root.right = CreateBST(arr,mid+1,end);
        return root;
    }

    public static void main(String[] args) {
        int  arr[] = {3,5,6,8,10,11,12};

//                    8
//                /      \
//              5         11
//            / \      /     \
//           3   6    10     11
//        expected BST

        Node root = CreateBST(arr,0,arr.length-1);
        System.out.println("The preorder sequence of BST is  :");
        preorder(root);
    }
}
//output:
// The preorder sequence of BST is  :
// 8 5 3 6 11 10 12