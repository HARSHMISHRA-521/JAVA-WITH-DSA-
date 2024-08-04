package CH05_BASIC_SORTING_ALGO;

/**
 * Class implementing Shell Sort algorithm in Java.
 * Shell Sort is an optimization over Insertion Sort that allows the exchange of far-apart elements.
 * The idea is to arrange the list of elements so that, starting anywhere, taking every hth element
 * produces a sorted list. Such a list is said to be h-sorted.
 *
 * Time Complexity:
 * - Best Case: O(n log n)
 * - Average Case: O(n^1.5)
 * - Worst Case: O(n^2)
 *
 * Shell Sort is not stable but it is adaptive.
 */

public class Shell_Sort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array:");
        printArray(arr);

        shellSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }

    /**
     * Function to perform Shell Sort on the given array.
     *
     * @param arr The array to be sorted.
     */
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) {
                // Save arr[i] in temp and make a hole at position i
                int temp = arr[i];
                int j;

                // Shift earlier gap-sorted elements up until the correct location for arr[i] is found
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                // Put temp (the original arr[i]) in its correct location
                arr[j + gap] = temp;

                /*
                // Inefficient way with swaps:
                // This method involves unnecessary swaps which increase the number of operations,
                // leading to less efficient sorting compared to the shifting method.
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] < arr[j + gap]) {
                        break;
                    } else {
                        // Swap arr[j] and arr[j + gap]
                        int tempSwap = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = tempSwap;
                    }
                }
                */
            }
        }
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

