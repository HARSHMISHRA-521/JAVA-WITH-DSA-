public class                                                                                counting_sort {
    /**
     * O(best)= O(worst)=O(average) = O(n+k) ,
     * where k is the range of the non-negative values
     * @param arr
     */
    public static void counting(int arr[]) {
        // Find the maximum element in the array
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // Create an array for storing frequency of each element
        int count[] = new int[largest + 1]; // +1 because we take index from 0

        // Calculate the frequency of each element in the array
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Sort the array
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    // Print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1, 4, 1, 3, 2, 4, 3, 7};
        System.out.println("Before sorting:");
        printArray(arr);
        counting(arr);
        System.out.println("After sorting:");
        printArray(arr);
    }
}
