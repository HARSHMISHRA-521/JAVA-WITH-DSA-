package CH10_DIVIDENCONQUER;
//Question 3 : Given an array of integers. Find the Inversion Count in the array. (HARD)
//        Inversion Count: For an array, inversion count indicates how far (or close) the array is from
//        being sorted. If the array is already sorted then the inversion count is 0. If an array is
//        sorted in the reverse order then the inversion count is the maximum.
//        Formally, two elements a[i] and alj] form an inversion if a[i] > ali] and i < j.
//        : N = 5, arr[] = {2, 4, 1, 3, 5}
//        Sample Input 1
////        Sample Output 1 : 3, because it has 3 inversions - (2, 1), (4 1), (4 3).
//: N = 5, arr[] = {2 3, 45, 6}
//        Sample Input 2
//        Sample Output 2 : 0, because the array is already sorted
//        : N = 3, arro = {5, 5, 5}
//        Sample Input 3
//        Sample Output 3
//        : because all the elements Of the array are the same & already in a sorted
//        manner.

public class inversion_count_MergeSort { //O(n log n)
    public static int countInversions(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSortAndCount(nums, temp, 0, nums.length - 1);
    }

    private static int mergeSortAndCount(int[] nums, int[] temp, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            count += mergeSortAndCount(nums, temp, left, mid);
            count += mergeSortAndCount(nums, temp, mid + 1, right);
            count += mergeAndCountSplitInversions(nums, temp, left, mid, right);
        }

        return count;
    }

    private static int mergeAndCountSplitInversions(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int count = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                count += mid - i + 1; // Count split inversions
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (i = left; i <= right; i++) {
            nums[i] = temp[i];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int inversions = countInversions(nums);
        System.out.println("Number of inversions: " + inversions); // Output: 6
    }
}
//
//Idea:
//        The Merge Sort approach utilizes the divide-and-conquer technique to count inversions
//        in an array efficiently. The idea is to divide the array into smaller subarrays, count
//        the inversions in each subarray, and then merge the subarrays while counting the split inversions.
//
//        Trick:
//        The trick in this approach is that during the merging step, we can determine the number of
//        inversions by observing the relative order of elements from the two subarrays being merged.
//        When an element from the right subarray is smaller than an element from the left subarray,
//        it indicates the presence of inversions.
//
//        Explanation:
//
//        The countInversions method is the entry point that initializes a temporary array
//        and calls the mergeSortAndCount method to perform merge sort and count the inversions.
//        The mergeSortAndCount method recursively divides the array into smaller subarrays until the
//        subarrays have a size of 1. It counts the inversions by recursively calling itself and the
//        mergeAndCountSplitInversions method.
//        The mergeAndCountSplitInversions method merges the two subarrays while counting the split inversions
//        . It uses three pointers (i, j, and k) to track the elements from the left subarray, right subarray,
//        and temporary array, respectively. When an inversion is found, the count is incremented by the number
//        of remaining elements in the left subarray (mid - i + 1).
//        Finally, the merged array is copied back to the original array, and the count of inversions is returned.

//            Left Subarray                        Right Subarray
//           x,x,x , 7 ,9,12                           x, x , 5 , 6,8,10
//                  (i)                                       j
//
//                 As 7 > 5, (7, 5) pair forms an inversion pair.
//                Also. as left subarray is sorted. it is obvious that elements 9 & 12 will also form inversion
//               pairs with element 5 i.e. (9, 5) and (12, 5).
//               So we can say that for element 5, total inversions are 3, which is exactly equal to the
//               number of elements left in the left subarray.