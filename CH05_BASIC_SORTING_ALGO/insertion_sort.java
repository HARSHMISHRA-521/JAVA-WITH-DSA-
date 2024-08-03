package CH05_BASIC_SORTING_ALGO;

public class insertion_sort {
    // Method to perform insertion sort on the input array
    public static void insertion(int[] arr) {
        // Loop through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i]; // Store the current element in a variable
            int prev = i - 1; // Store the index of the previous element

            // Move elements of arr[0..i-1], that are greater than the current element, to one position ahead
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev]; // Shift the element one position ahead
                prev--; // Decrement the index of the previous element
            }

            // Insert the current element in its correct position
            arr[prev + 1] = curr;
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Declare and initialize the array
        int [] arr ={4,1,3,5,2};
        System.out.println("Array before sorting");
        printArray(arr); // Print the original array
        insertion(arr); // Sort the array using insertion sort
        System.out.println("Array after sorting");
        printArray(arr); // Print the sorted array
    }
}


//        The insertion sort algorithm sorts an array by inserting each element
//        in its correct position, one at a time. In the code above,
//        the insertion method takes an array as input and performs the insertion sort algorithm on it.
//
//        The algorithm works by looping through the array, starting from the second element.
//        For each element, it compares it with the previous element(s) and shifts
//        the previous elements one position ahead if they are greater than the current element.
//        This is done until the correct position for the current element is found,
//        and then it is inserted in that position.