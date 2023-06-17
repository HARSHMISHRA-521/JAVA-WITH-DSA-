package CH14_STACK;

//Trapping Rain Water
//        We have an array of N non-negative integers arr[] representing an elevation map where the
//        width of each bar is 1 compute how much water it is able to trap after raining.
//        Note: We have already solved this Question using Arrays but you have to now solve this using
//        a Stack.
//
//        explain and Time Complexity : o(n)
//        Space Complexity: o(n)

import java.util.Stack;

public class TrappingRainWater {
    public static int trapWater(int[] arr) {
        int waterTrapped = 0; // Variable to track the amount of water trapped
        Stack<Integer> stack = new Stack<>(); // Stack to store the indices of bars

        for (int currentIndex = 0; currentIndex < arr.length; currentIndex++) {
            while (!stack.isEmpty() && arr[currentIndex] > arr[stack.peek()]) {
                // If the current bar's height is greater than the height of the bar at the top of the stack
                int prevIndex = stack.pop(); // Pop the index of the bar at the top of the stack

                if (stack.isEmpty()) {
                    break;
                }

                int distance = currentIndex - stack.peek() - 1; // Calculate the distance between the current bar and the bar at prevIndex
                int heightDiff = Math.min(arr[currentIndex], arr[stack.peek()]) - arr[prevIndex]; // Calculate the height difference between the current bar and the bar at prevIndex
                waterTrapped += distance * heightDiff; // Add the trapped water for the current segment
            }

            stack.push(currentIndex); // Push the current index onto the stack
        }

        return waterTrapped; // Return the total amount of water trapped
    }

    public static void main(String[] args) {
        int[] elevationMap = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        int trappedWater = trapWater(elevationMap);
        System.out.println("Trapped Water: " + trappedWater);
    }
}


//steps
//  Here is a summary of the steps:
//
//        - Create an empty stack to store indices of bars that are bounded by longer bars and hence, may store water.
//        - Initialize waterTrapped to zero to keep track of the cumulative amount of water trapped by all the bars.
//        - Loop through the array from left to right and for each bar, do the following:
//        - While the stack is not empty and the current bar is higher than the top of the stack, pop
//        the top of the stack and calculate the water trapped by it. The water trapped by the popped
//        bar is equal to the minimum of the current bar and the previous bar in the stack, minus the
//        height of the popped bar, multiplied by the distance between the current bar and the previous bar in the stack.
//        - Push the current index to the stack.
//        - Return waterTrapped as the final answer.
//
//        The time complexity of this algorithm is O(n) because we traverse the array once and each element
//        is pushed and popped at most once from the stack. The space complexity is O(n) because we use a stack
//        that can store at most n elements.