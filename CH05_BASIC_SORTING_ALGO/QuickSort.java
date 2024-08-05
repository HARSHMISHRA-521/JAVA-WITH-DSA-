package CH05_BASIC_SORTING_ALGO;

/**
 * Class implementing Quick Sort algorithm in Java.
 * Quick Sort is a Divide and Conquer algorithm that picks an element as a pivot
 * and partitions the given array around the picked pivot.
 *
 * Time Complexity:
 * - Best Case: O(n log n)
 * - Average Case: O(n log n)
 * - Worst Case: O(n^2)
 *
 * Quick Sort is not stable but is in-place.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        printArray(arr);
    }

    /**
     * Function to perform Quick Sort on the given array.
     *
     * @param arr The array to be sorted.
     * @param low The starting index of the array to be sorted.
     * @param high The ending index of the array to be sorted.
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Function to partition the array on the basis of pivot.
     *
     * @param arr The array to be partitioned.
     * @param low The starting index of the array.
     * @param high The ending index of the array.
     * @return The index of the pivot element.
     */
    public static int partition(int[] arr, int low, int high) {
        // Pivot is the element at the low index
        int pivot = arr[low];
        int left = low + 1;
        int right = high;

        while (left <= right) {
            // Find an element larger than the pivot
            while (left <= right && arr[left] <= pivot) {
                left++;
            }

            // Find an element smaller than the pivot
            while (left <= right && arr[right] > pivot) {
                right--;
            }

            // Swap elements at left and right indices
            if (left < right) {
                swap(arr, left, right);
            }
        }

        // Place the pivot in the correct position
        swap(arr, low, right);

        return right;
    }

    /**
     * Function to swap two elements in the array.
     *
     * @param arr The array.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Function to print the elements of an array.
     *
     * @param arr The array whose elements need to be printed.
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
