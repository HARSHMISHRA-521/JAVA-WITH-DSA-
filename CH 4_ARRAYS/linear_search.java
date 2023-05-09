public class linear_search {
    static int   linear(int  arr[],int key){
        for(int i=1;i<= arr.length;i++){
            if(key==arr[i]){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] ={2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int index = linear(arr,10);
        if(index==-1){
            System.out.println("number not found!");
        }
        else{
            System.out.println("the index of number is :"+index);
        }
    }
}
