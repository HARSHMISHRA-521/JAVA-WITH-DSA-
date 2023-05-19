package CH11_BACKTRACKING;
//tc:O(n*2^n)  || sc:O(n)
public class subsets {
    // Function to find subsets of a string
    public static void findSubsets(String str, int i, String ans) {

        // Base case: If we have reached the end of the string
        if (i == str.length()) {
            // If the subset is empty, print "NULL"
            if (ans.length() == 0) {
                System.out.println("NULL");
            }
            // Otherwise, print the subset
            else {
                System.out.println(ans);
            }
            return;
        }

        // Recursive calls

        // Include the current character in the subset (choice is "yes")
        findSubsets(str, i + 1, ans + str.charAt(i));

        // Exclude the current character from the subset (choice is "no")
        findSubsets(str, i + 1, ans);
    }

    public static void main(String[] args) {
        // Start the recursion from the first character of the input string with an empty subset
        findSubsets("abc", 0, "");
    }

}
