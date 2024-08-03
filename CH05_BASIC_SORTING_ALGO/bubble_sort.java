public class bubble_sort {
    // Bubble Sort method to sort an array in ascending order

    /**
     * Best case  :O(n)
     * worst case  = Average Case = O(n^2)
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        // length of the input array
        int n = arr.length;

        // traverse through the array n-1 times
        for (int i = 0; i < n - 1; i++) {
            // flag to check if any swap was made during this iteration
            boolean swapped = false;
            // traverse through the unsorted part of the array
            // the last i elements are already sorted
            for (int j = 0; j < n - i - 1; j++) {
                // swap if the current element is greater than the next element
                if (arr[j] > arr[j + 1]) {       //here we can change > to < for descending order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // set the swapped flag to true
                    swapped = true;
                }
            }
            // if no swap was made during this iteration, the array is already sorted
            if (!swapped) {
                System.out.println("Array is already sorted");
                return;
            }
        }
    }

    // method to print the sorted array
    public static void printArray(int[] arr) {
        System.out.print("Sorted array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // main method to test the BubbleSort class
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6}; // sorted array
        int[] arr2 = {5, 1, 4, 2, 3}; // unsorted array

        // test with sorted array
        System.out.print("Input array: ");
        printArray(arr1);
        bubbleSort(arr1);
        printArray(arr1);

        // test with unsorted array
        System.out.print("Input array: ");
        printArray(arr2);
        bubbleSort(arr2);
        printArray(arr2);
    }
}
