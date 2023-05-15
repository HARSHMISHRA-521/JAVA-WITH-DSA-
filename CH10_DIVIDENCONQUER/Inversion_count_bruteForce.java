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


public class Inversion_count_bruteForce { //O(n^2)
    public static int countInversions(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
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
//Approach 1 - Brute Force Approach
//        Idea: Traverse through the array, and for every index,
//        find the number of smaller elements on its right side of the array. This
//        can be done using a nested loop. Sum up the counts for
//        all indexes in the array and print the sum.
//
//        The time complexity of this brute force approach is O(n^2), where n is the size of the
//        array. We need to compare each element with every other element to count the inversions.