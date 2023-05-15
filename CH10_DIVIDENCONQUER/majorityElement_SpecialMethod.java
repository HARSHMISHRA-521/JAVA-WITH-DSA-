package CH10_DIVIDENCONQUER;
//Question 2: Given an array nums of size n, you need to find the majority element. The majority element is defined as the element that appears more than n/2 times in the array. You can assume that the majority element always exists in the array.
//
//        Write a function that takes an array nums as input and returns the majority element.
//
//        Sample Input 1:
//        nums = [3, 2, 3]
//        Sample Output 1:
//        3
//
//        Sample Input 2:
//        nums = [2, 2, 1, 1, 1, 2, 2]
//        Sample Output 2:
//        2
//
//        Constraints:
//
//        1 <= n <= 10^9
//        -10^9 <= nums[i] <= 10^9
//        Please provide the corrected question if any part is still unclear.

import java.util.Arrays;

public class majorityElement_SpecialMethod { // O(n log n)
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums); // Sort the array in ascending order
        return nums[nums.length / 2]; // Return the element at the middle index
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println("Majority Element: " + majorityElement(nums1)); // Output: 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + majorityElement(nums2)); // Output: 2
    }
}

//
//    To find the majority element in an array nums of size n, where the majority
//    element appears more than [n/2] times, you can use the following approach:
//
//        Sort the array nums in ascending order using a sorting algorithm with a
//        time complexity of O(n log n).
//        After sorting, the majority element will always be at the middle index
//        nums[n/2] due to the given constraint that the majority element exists in the array.
//        Return nums[n/2] as the majority element.
//The time complexity of this approach is O(n log n) due to the sorting step.