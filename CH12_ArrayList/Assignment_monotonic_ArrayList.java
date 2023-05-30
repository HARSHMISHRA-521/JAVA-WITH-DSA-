package CH12_ArrayList;
//Question 1 .
//        Monotonic ArrayList (EASY)
//        An Arraylist is monotonic if it is either monotone increasing or monotone decreasing.
//        An Arraylist nums is monotone increasing if for all i j, nums.get(i) nums.get(j). An
//        Arraylist nums is monotone decreasing if for all i j, nums.get(i) nums.get(j).
//        Given an integer Arraylist nums, return true if the given list is monotonic, or false otherwise.
//        Sample Input 1 : nums[1,2,2,3
//        Sample Output 1 : true
//        Sample Input 2 : nums = [6,5,4,4]
//        Sample Output 2 : true
//        Sample Input 3 : nums[1,3,2]
//        Sample Output 3 : false
//        Constraints
//        1<= nums.size() <= 105
//        -105 <= nums.get(i) <= 105

import java.util.ArrayList;

public class Assignment_monotonic_ArrayList {
    public static boolean isMonotonic(ArrayList<Integer> nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                isIncreasing = false;
            }
            if (nums.get(i) < nums.get(i + 1)) {
                isDecreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums1 = new ArrayList<Integer>();
        nums1.add(1);
        nums1.add(2);
        nums1.add(2);
        nums1.add(3);
        System.out.println("Sample Input 1: " + nums1);
        System.out.println("Sample Output 1: " + isMonotonic(nums1));

        ArrayList<Integer> nums2 = new ArrayList<Integer>();
        nums2.add(6);
        nums2.add(5);
        nums2.add(4);
        nums2.add(4);
        System.out.println("Sample Input 2: " + nums2);
        System.out.println("Sample Output 2: " + isMonotonic(nums2));

        ArrayList<Integer> nums3 = new ArrayList<Integer>();
        nums3.add(1);
        nums3.add(3);
        nums3.add(2);
        System.out.println("Sample Input 3: " + nums3);
        System.out.println("Sample Output 3: " + isMonotonic(nums3));
    }
}
