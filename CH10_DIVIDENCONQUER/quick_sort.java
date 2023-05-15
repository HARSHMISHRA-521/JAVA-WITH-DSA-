package CH10_DIVIDENCONQUER;
//average case tc:O(n log n)
//worst case tc:O(n^2)
//sc:O(1) ,i.e it does not require extra space like merge sort
public class quick_sort {
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[],int si,int ei){
//        base
        if(si>=ei){
            return;
        }
        //kaam
        int pidx = partition(arr,si,ei);//index of pivot
        quickSort(arr,si,pidx-1);//left
        quickSort(arr,pidx+1,ei);//right
    }

    public static int partition(int arr[],int si,int ei){
        int pivot = arr[ei];
        int i = si-1;//for making place for elements smaller than pivot number

        for(int j =si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;

            }
        }
//        FOR PIVOT POSITIONING
        i++;
        int temp =pivot;
        arr[ei]=arr[i];//not write pivot = arr[i],AS WE HAVE TO CHANGE THE VALUE
        arr[i]=temp;   //OF ARRAY NOT THE VARIABLE (CALL BY REFERENCE)
        return i;
    }

    public static void main(String[] args) {
        int arr[]={5,10,2,1,9,7,13,3,8};
        System.out.println("before sorting:");
        printArray(arr);
       quickSort(arr,0,arr.length-1);
        System.out.println("after sorting:");
        printArray(arr);
    }
}
