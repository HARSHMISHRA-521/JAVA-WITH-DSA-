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

public class majorityElement_bruteForce {  //O(n^2)
    public static int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }
            if (count > majorityCount) {
                return nums[i];
            }
        }

        // Majority element always exists, so this line won't be reached
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println("Majority Element: " + majorityElement(nums1)); // Output: 3

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + majorityElement(nums2)); // Output: 2
    }
}

//
//In this code, the outer loop iterates through each element in the array using the index i, while the inner loop
//        compares each element with every other element using the index j. The count of occurrences is incremented
//        when a match is found. If the count exceeds the majority count (nums.length / 2), we return the current
//        element as the majority element.
//
//        This implementation follows a traditional for loop in Java, where the iteration is controlled using the
//        index variables i and j.
//
//        The time complexity of this brute force approach is O(n^2), where n is the size of the array. This is
//        because we have nested loops, resulting in comparing each element with every other element.