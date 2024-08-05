package CH05_BASIC_SORTING_ALGO;

import java.util.Arrays;

/**
 * Class implementing Radix Sort algorithm in Java.
 * Radix Sort is a non-comparative sorting algorithm that sorts numbers by processing individual digits.
 * It processes the digits in either least significant digit (LSD) or most significant digit (MSD) order.
 *
 * Time Complexity:
 * - Best Case: O(nk) where k is the number of digits in the largest number
 * - Average Case: O(nk)
 * - Worst Case: O(nk)
 *
 * Radix Sort is stable but requires additional memory for sorting.
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Original Array:");
        printArray(arr);

        radixSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }

    /**
     * Function to perform Radix Sort on the given array.
     *
     * @param arr The array to be sorted.
     */
    public static void radixSort(int[] arr) {
        // Find the maximum number to know the number of digits
        int max = Arrays.stream(arr).max().getAsInt();

        // Do counting sort for every digit. Note that instead of passing the digit number,
        // exp is passed. exp is 10^i where i is the current digit number.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    /**
     * Function to perform Counting Sort based on the digit represented by exp.
     *
     * @param arr The array to be sorted.
     * @param exp The exponent representing the current digit position.
     */
    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the output array to arr[], so that arr now contains sorted numbers according to current digit
        System.arraycopy(output, 0, arr, 0, n);
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
