//       write a java program for
//        There is an integer array nums sorted in ascending order (with distinct values).
//        Prior to being passed to your function, nums is possibly rotated at an unknown
//        pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k],
//        nums[k+l],
//        nums[n-ll, nums[0J, nums[l],
//        nums[k-l)) (0-indexed). For
//        example, [O, 1 might be rotated
//        index 3 and
//        pivot
//        at
//        become ,21.
//        Given the array nums after the possible rotation and an integer target, return the
//        index of target if it is in nums, or-I if it is not in nums.
//        You must write an algorithm with O(log n) runtime complexity.

public class SearchRotatedSortedArray {
    public static int search(int num[],int target){
        int left = 0;
        int right = num.length-1;
        while(left<=right){
            int mid = left +(right-left)/2;

            if(num[mid]==target){
                return mid;
            }

            else if(num[mid]>=num[left]){
                if(target>=num[left] && target<num[mid]){
                    right= mid-1;
                }
                else{
                    left =mid+1;
                }
            }

            else{
                if(target > num[mid] && target <=num[right]){
                    left =mid+1;
                }
                else{
                    right =mid-1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = search(nums, target);
        System.out.println("Result: " + result);

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 3;
        result = search(nums, target);
        System.out.println("Result: " + result);

        nums = new int[]{1};
        target = 0;
        result = search(nums, target);
        System.out.println("Result: " + result);

        nums = new int[]{1, 3};
        target = 2;
        result = search(nums, target);
        System.out.println("Result: " + result);
    }
}
//
//Here's how the algorithm works:
//
//        We initialize left to 0 and right to nums.length - 1.
//        We use a while loop to search for target in the array nums.
//        In each iteration of the loop, we calculate the middle index mid
//        as the average of left and right.
//        We compare nums[mid] to target. If they are equal, we have found
//        the index of target and return mid.
//        If nums[mid] >= nums[left], then the left half of the array is sorted
//        in ascending order. We check if target is within this range.
//        If it is, we update right to mid - 1 to search this half of the array.
//        Otherwise, we update left to mid + 1 to search the right half of the array.
//        If nums[mid] < nums[left], then the right half of the array is
//        sorted in ascending order. We check if target is within this range.
//        If it is, we update left to mid + 1 to search this half of the array.
//        Otherwise, we update right to mid - 1 to search the left half of the array.
//        If we exit the loop without finding target, we return -1.
//        The time complexity of this algorithm is O(log n) since we divide the search space in half at each iteration.
//
//        The time complexity of this algorithm is O(log n), where n is the
//        number of elements in the input array nums. This is because we
//        perform a binary search on the array, cutting the search space
//        in half at each iteration. Since binary search has a time complexity
//        of O(log n), the overall time complexity of this algorithm is also O(log n).