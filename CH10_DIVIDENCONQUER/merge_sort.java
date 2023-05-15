package CH10_DIVIDENCONQUER;
//tc:O(n log n)
//sc:O(n) i.e,it takes extra space
public class merge_sort {
    public static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[],int si,int ei){
        //base case
        if(si>=ei){
            return;
        }

        //kaam
        int mid = si + (ei-si)/2;
        mergeSort(arr,si,mid);//left part
        mergeSort(arr,mid+1,ei);//right part
        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];//arr is one+ size of last index no
        int i = si;//iterator for left part
        int j = mid+1;//iterator for right part
        int k = 0;//iterator for temp

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }

        //for left's left part
        while(i<=mid){
            temp[k++]=arr[i++];
        }

        //for right's left part
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        //copy the temp to original array
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }

    public static void main(String[] args) {
        int arr[]={5,10,2,1,9,7,13,3,8};
        System.out.println("before sorting:");
        printArray(arr);
        mergeSort(arr,0,arr.length-1);
        System.out.println("after sorting:");
        printArray(arr);
    }
}
