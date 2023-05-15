package CH09_RECURSION;

public class Assignment_qNo_4 {
    // Define a method to count the number of substrings that start and end with the same character
    // The method takes four parameters: the input string, the starting index, the ending index, and the length of the substring
    public static int countSubstrs(String str,int i,int j,int n){

        // Base case 1: if the substring has one character, return 1
        if(n==1){
            return 1;
        }

        // Base case 2: if the substring has zero or negative characters, return 0
        if(n<=0){
            return 0;
        }

        // Recursive case: count the number of substrings in three parts:
        // 1) The substring that excludes the first character (i+1,j,n-1)
        // 2) The substring that excludes the last character (i,j-1,n-1)
        // 3) The substring that excludes both the first and last characters (i+1,j-1,n-2)
        // Add the counts of the first two parts and subtract the count of the third part to avoid
        // counting the same substring twice

        int res = countSubstrs(str,i+1,j,n-1) + countSubstrs(str,i,j-1,n-1) - countSubstrs(str,i+1,j-1,n-2);

        // If the first and last characters are equal, then there is one more substring that includes them
        // Increment res by one
        if(str.charAt(i)==str.charAt(j)){
            res++;
        }

        // Return the final result
        return res;
    }

    public static void main(String[] args) {

        // Test the method with a sample input and output
        String str = "abcab";
        int n = str.length();

        // Call the method with the input string, starting index 0, ending index n-1, and length n
        System.out.println(countSubstrs(str,0,n-1,n)); // Output: 7

    }
}

//
//        The code works by using a recursive method that takes four parameters: t
//        he input string, the starting index, the ending index, and the length of the substring.
//        The method has two base cases and one recursive case.
//
//        The first base case is when the substring has one character. In this case,
//        there is one such substring that starts and ends with the same character, so the method returns 1.
//
//        The second base case is when the substring has zero or negative characters.
//        In this case, there are no such substrings, so the method returns 0.
//
//        The recursive case is when the substring has at least two characters.
//        In this case, the method counts the number of substrings in three parts:
//
//         This line is the recursive case of the method. It counts the number of substrings
//         that start and end with the same character in three parts:
//
//The substring that excludes the first character (i+1,j,n-1)
//The substring that excludes the last character (i,j-1,n-1)
//The substring that excludes both the first and last characters (i+1,j-1,n-2)
//The method adds the counts of the first two parts and subtracts the count
// of the third part. This is to avoid counting the same substring twice in different parts.
// For example, if the input is “ababa”, then the three parts are:
//
//“baba” (excludes the first character ‘a’)
//“abab” (excludes the last character ‘a’)
//“bab” (excludes both ‘a’ and ‘a’)
//The method calls itself recursively on each part and stores the result in res.
// The counts of the first two parts are 4 and 4 respectively. The count of the third part is 3.
// The method subtracts 3 from 4 + 4 to get 5. This is because “a” and “b” are counted twice in both “baba” and “abab”,
// but they should only be counted once. So, res is 5 at this point.
//
//Then, the method checks if the first and last characters are equal. If they are, then there is one more
// substring that includes them, so it increments res by one. In this case, they are equal (‘a’ and ‘a’),
// so res becomes 6.
//
//Finally, the method returns res as the final result for this recursive case.