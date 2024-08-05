package CH05_BASIC_SORTING_ALGO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class implementing Bucket Sort algorithm in Java.
 * Bucket Sort is a distribution sort that works by distributing elements into buckets,
 * then sorting each bucket individually, and finally concatenating the sorted buckets.
 *
 * Time Complexity:
 * - Best Case: O(n + k) where k is the number of buckets
 * - Average Case: O(n + k)
 * - Worst Case: O(n^2)
 *
 * Bucket Sort is stable if the underlying sorting algorithm used within the buckets is stable.
 */
public class BucketSort {
    public static void main(String[] args) {
        float[] arr = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};

        System.out.println("Original Array:");
        printArray(arr);

        bucketSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }

    /**
     * Function to perform Bucket Sort on the given array.
     *
     * @param arr The array to be sorted.
     */
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0)
            return;

        // Create n empty buckets
        @SuppressWarnings("unchecked")
        List<Float>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }

        // Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float num : buckets[i]) {
                arr[index++] = num;
            }
        }
    }

    /**
     * Function to print the elements of an array.
     *
     * @param arr The array whose elements need to be printed.
     */
    public static void printArray(float[] arr) {
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
