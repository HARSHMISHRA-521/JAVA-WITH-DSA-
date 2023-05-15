package CH10_DIVIDENCONQUER;

public class search_in_rotatedSorted_array {
    public static int search(int arr[],int tar,int si,int ei){
        //base
        if(si>ei){
            return  -1;
        }
        //kaam
        int mid = si+(ei-si)/2; //(si+ei)/2

        //case found
        if(arr[mid]==tar){
            return mid;
        }
        //case :mid lie on L1
        if(arr[si]<=arr[mid]){
            //case a: left part
            if(arr[si]<=tar && tar<=arr[mid]){
                return search(arr,tar,si,mid-1);
            }
            else{
                //case b: part right
                return search(arr,tar,mid+1,ei);
            }
        }

        //case : mid lies on line L2
        else{   // arr[mid]<=arr[ei]
            //case c: on right
            if(arr[mid]<=tar && tar<= arr[ei]){
                return search(arr,tar,mid+1,ei);
            }
            //case d: on left
            else{
                return search(arr,tar,si,mid-1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] ={4,5,6,7,0,1,2};
        int taridx = search(arr,1,0,arr.length-1);
        System.out.println("Index of target element is : "+taridx);
    }
}
