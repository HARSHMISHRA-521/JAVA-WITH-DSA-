public class binary_search {
    public static int bs(int arr[],int key){
        int start =0,end=arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==key){
                return mid;
            }
            if(arr[mid]>key){
                end =mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] ={2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int index = bs(arr,1);
        if(index==-1){
            System.out.println("number not found!");
        }
        else{
            System.out.println("the index of number is :"+(index+1));
        }
    }
}
