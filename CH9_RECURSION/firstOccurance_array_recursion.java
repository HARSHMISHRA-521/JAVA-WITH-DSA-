package CH9_RECURSION;

//time and space complexity is O(n)

public class firstOccurance_array_recursion {
    public static int firstOcc(int []arr,int key,int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOcc(arr,key,i+1);
    }

    public static void main(String[] args) {
        int [] arr = {8,3,6,9,5,10,2,5,3};
        int key = 15;
        System.out.println(firstOcc(arr,key,0));
    }
}
