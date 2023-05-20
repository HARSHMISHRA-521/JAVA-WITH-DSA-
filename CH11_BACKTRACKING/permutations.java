package CH11_BACKTRACKING;
//O(n*n!)
public class permutations {
    public static void findPermutation(String str, String ans) {
        // Base case: If the input string is empty, we have found a permutation
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Recursive case: Generate permutations by selecting each character in the string
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1); // Exclude the character at index i
            findPermutation(newStr, ans + curr);
        }
    }

    public static void main(String[] args) {
        findPermutation("abc", "");
    }
}
