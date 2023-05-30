package CH12_ArrayList;//O(n log n)
// :->The time complexity of the code is O(n log n),
// where n is the size of the given arraylist. This is because the sorting method
// takes O(n log n) time, and the loop takes O(n) time.
// Therefore, the total time taken by the code is O(n log n) + O(n) = O(n log n).

//Question 2 :
//        Lonely Numbers in ArrayList
//        (MEDIUM)
//        You are given an integer arraylist nums. A number x is lonely when it appears only once, and
//        no adjacent numbers (i.e. x + 1 and x- 1) appear in the arraylist.
//        Return all lonely numbers in nums. You may return the answer in any order.
//        Sample Input 1 : nums = [1
//        Sample Output 1 : [10,8]
//        Explanation :
//        - 10 is a lonely number since it appears exactly once and 9 and 11 does not appear in nums.
//        - 8 is a lonely number since it appears exactly once and 7 and 9 does not appear in nums.



// import the ArrayList and Collections classes
import java.util.ArrayList;
import java.util.Collections;

public class Assignment_lonelyNumber {

    // define a function to find the lonely numbers in an arraylist
    public static ArrayList<Integer> lonelyNumbers(ArrayList<Integer> nums) {
        // create an empty arraylist to store the lonely numbers
        ArrayList<Integer> result = new ArrayList<Integer>();
        // sort the given arraylist in ascending order using the Collections class
        Collections.sort(nums);
        // loop through the sorted arraylist
        for (int i = 0; i < nums.size(); i++) {
            // get the current number
            int x = nums.get(i);
            // assume that the current number is lonely
            boolean isLonely = true;
            // check if the current number is equal to the previous number or the next number
            // if so, then the current number is not lonely and we set isLonely to false
            if (i > 0 && ((x-1) == nums.get(i - 1) || (x) == nums.get(i - 1))) {
                isLonely = false;
            }
            if (i < nums.size() - 1 && ((x+1) == nums.get(i + 1) || (x) == nums.get(i + 1))) {
                isLonely = false;
            }
            // if the current number is lonely
            if (isLonely) {
                // add it to the result arraylist
                result.add(x);
            }
        }
        // return the result arraylist
        return result;
    }

    // test the function with an example
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        nums.add(0);
        nums.add(1);
        nums.add(3);
        nums.add(5);
        nums.add(7);
        System.out.println("The lonely numbers in " + nums + " are:");
        System.out.println(lonelyNumbers(nums));
    }
}