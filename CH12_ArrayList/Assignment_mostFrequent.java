package CH12_ArrayList; //O(n)
//Question 3 :
//        Most Frequent Number following Key (EASY)
//        You are given an integer Arraylist nums. You are also given an integer key, which is present in
//        nums.
//        For every unique integer target in nums, count the number of times target immediately follows
//        an occurrence of key in nums. In other words, count the number of indices i such that:
//        0 <= i <= nums.size() - 2,
//        nums.get(i) -= key and,
//        nums.get(i+l) == target.
//        Return the target with the maximum count.
//        (AS.I..LID.Z.Q.L - that the target with maximum count is unique.)
//        Sample Input 1 :nums = [1 , key = 1
//        Sample Output 1
//        : 100
//        Explanation :
//        For target = 100, there are 2 occurrences at indices 1 and 4 which follow an occurrence of key.
//        No other integers follow an occurrence of key, so we return 100.


    // import the ArrayList class
import java.util.ArrayList;

public class Assignment_mostFrequent {

    // define a function to find the most frequent number following key in an arraylist
    public static int mostFrequent (ArrayList<Integer> nums, int key) {
        // create an array of size 1000 to store the counts of each number following key
        // assume that the numbers in the arraylist are between 1 and 1000
        int[] result = new int[1000];
        // loop through the given arraylist except the last element
        for (int i = 0; i < nums.size() - 1; i++) {
            // if the current number is equal to the key
            if (nums.get(i) == key) {
                // increment the count of the next number by one in the result array
                // use the next number minus one as the index in the result array
                result[nums.get(i + 1) - 1]++;
            }
        }
        // initialize the maximum count to the minimum possible integer value
        int max = Integer.MIN_VALUE;
        // initialize the answer to zero
        int ans = 0;
        // loop through the result array
        for (int i = 0; i < 1000; i++) {
            // if the current count is greater than the maximum count
            if (result[i] > max) {
                // update the maximum count to the current count
                max = result[i];
                // update the answer to the current number plus one
                ans = i + 1;
            }
        }
        // return the answer
        return ans;
    }

    // test the function with an example
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(1);
        nums.add(100);
        nums.add(1);
        nums.add(5);
        nums.add(3);
        nums.add(1);
        nums.add(100);
        nums.add(2);
        int key = 1;
        System.out.println("The most frequent number following " + key + " in " + nums + " is:");
        System.out.println(mostFrequent(nums, key));
    }

// The time complexity of this solution is O(n), where n is the size of the given arraylist.
// This is because we loop through the arraylist once, which takes O(n) time, and we loop through
// the result array once, which takes O(1000) time. Since O(1000) is a constant, we can ignore it
// and say that the total time taken by the solution is O(n) + O(1000) = O(n).

}
