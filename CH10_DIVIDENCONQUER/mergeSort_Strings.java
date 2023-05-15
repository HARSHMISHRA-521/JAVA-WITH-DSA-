package CH10_DIVIDENCONQUER;
//Question 1 : Apply Merge sort to sort an array of Strings. (Assume that all the characters in
//        all the Strings are in lowercase). (EASY)
//        Sample Input 1 : arr = { "sun", "earth", "mars", "mercury" }
//        Sample Output 1 : arr { "earth", "mars', "mercury", sun"}

//
//To apply Merge Sort to sort an array of strings, you can follow these steps:
//
//        Implement the merge sort algorithm, but instead of
//        comparing integers, compare strings using the compareTo method.

public class mergeSort_Strings {
    public static void printArray(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(String arr[], int si, int ei) {
        // Base case
        if (si >= ei) {
            return;
        }

        // Divide the array into two halves
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid); // Sort the left half
        mergeSort(arr, mid + 1, ei); // Sort the right half
        merge(arr, si, mid, ei); // Merge the sorted halves
    }

    public static void merge(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei - si + 1]; // Array to store merged values
        int i = si; // Iterator for the left part
        int j = mid + 1; // Iterator for the right part
        int k = 0; // Iterator for the temp array

        while (i <= mid && j <= ei) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements from the left part
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // Copy the remaining elements from the right part
        while (j <= ei) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copy the merged values from the temp array back to the original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        String arr[] = { "sun", "earth", "mars", "mercury" };
        System.out.println("Before sorting:");
        printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("After sorting:");
        printArray(arr);
    }
}
