package CH14_STACK;  //Time Complexity : o(n)
                    // Space Complexity: o(n)

//The given question is asking us to decode an encoded string according to a specific pattern.
//
//        In the provided pattern, a number followed by a string in square brackets represents a
//        repetition of that string. The number indicates the number of times the string should be repeated.
//
//        Let's break down the examples to understand the decoding process:
//
//        Example 1:
//        Input: 2[cv]
//        Output: cvcv
//
//        In this example, the input string is "2[cvl]". We need to decode it by repeating the string "cvl"
//        two times. Therefore, the decoded output is "cvcv".
//
//        Example 2:
//        Input: 3[b2[v]]L
//        Output: bvvbvvbvvL

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;

        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // Update the count if a digit is encountered
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current count and current string onto their respective stacks
                countStack.push(count);
                stringStack.push(currentString.toString());
                // Reset the current count and current string
                count = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                // Pop the count and string from their stacks
                int repeatCount = countStack.pop();
                String previousString = stringStack.pop();
                // Repeat the current string by the count and append it to the previous string
                StringBuilder repeatedString = new StringBuilder();
                for (int j = 0; j < repeatCount; j++) {
                    repeatedString.append(currentString);
                }
                currentString = new StringBuilder(previousString + repeatedString.toString());//we can also use
            } else {                                                                    //repeatedString only
                // Append the character to the current string
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        String input1 = "2[cvl]";
        System.out.println("Input: " + input1);                 //Input: 2[cvl]
        System.out.println("Output: " + decodeString(input1));  //Output: cvlcvl

        String input2 = "3[b2[v]]L";
        System.out.println("Input: " + input2);                 // Input: 3[b2[v]]L
        System.out.println("Output: " + decodeString(input2));  //Output: bvvbvvbvvL
    }
}

//
//explanation:
//        The solution uses two stacks: countStack to store the count values, and stringStack
//        to store the strings encountered before the opening bracket.
//
//        We iterate through each character in the input string using a for-each loop.
//
//        If a digit is encountered, we update the count variable by multiplying it by 10 and adding the digit's value.
//
//        If an opening bracket '[' is encountered, we push the current count and the current string onto their
//        respective stacks. We also reset the count variable and create a new currentString StringBuilder.
//
//        If a closing bracket ']' is encountered, we pop the top count and string from their stacks. We repeat
//        the currentString by the count and append it to the previous string. The result is stored back in currentString.
//
//        For any other character that is not a digit or bracket, we simply append it to the currentString.
//
//        Finally, we return the decoded string stored in currentString.
//
//        The time complexity of this solution is O(N), where N is the length of the input string. We iterate through
//        each character in the string exactly once. The space complexity is also O(N) as we use stacks to store the
//        count and string values.

//    Multiplying the count by 10 is done to handle cases where the encoded string contains multiple digits representing
//        numbers greater than 9.
//For example, let's consider the input string "23[abc]":
//
//        When we encounter the digit '2', the count is initially 0. Multiplying it by 10 (0 * 10)
//        doesn't change its value. Then we add the numeric value of '2' to the count (2 - '0'). The updated count becomes 2.
//        When we encounter the digit '3', we multiply the existing count (2) by 10, shifting it to the left and making
//        it 20. Adding the numeric value of '3' (3 - '0') to the multiplied count, the updated count becomes 23.
//        By using this approach, we ensure that the count is correctly updated to reflect the value of the digit
//        encountered in the input string, regardless of whether it is a single-digit or multiple-digit number.

//
//Certainly! Let's go through a dry run of the provided code using the example "2[ab3[c]]".
//
//        Input: "2[ab3[c]]"
//
//        Initialize the necessary variables and stacks:
//
//        countStack: Stack to store the counts (empty)
//        stringStack: Stack to store the strings (empty)
//        currentString: StringBuilder to store the current string (empty)
//        count: 0
//        Iterate through each character in the input string:
//
//        Iteration 1:
//
//        Current character: '2'
//        It is a digit, so update the count:
//        count = count * 10 + (2 - '0') = 0 * 10 + 2 = 2
//        Iteration 2:
//
//        Current character: '['
//        It is an opening bracket, so perform the following actions:
//        Push the current count (2) to countStack.
//        Push the current string ("") to stringStack.
//        Reset the count to 0.
//        Reset the current string to an empty StringBuilder.
//        Iteration 3:
//
//        Current character: 'a'
//        It is a letter, so append it to the current string:
//        currentString = "a"
//        Iteration 4:
//
//        Current character: 'b'
//        It is a letter, so append it to the current string:
//        currentString = "ab"
//        Iteration 5:
//
//        Current character: '3'
//        It is a digit, so update the count:
//        count = count * 10 + (3 - '0') = 0 * 10 + 3 = 3
//        Iteration 6:
//
//        Current character: '['
//        It is an opening bracket, so perform the following actions:
//        Push the current count (3) to countStack.
//        Push the current string ("ab") to stringStack.
//        Reset the count to 0.
//        Reset the current string to an empty StringBuilder.
//        Iteration 7:
//
//        Current character: 'c'
//        It is a letter, so append it to the current string:
//        currentString = "c"
//        Iteration 8:
//
//        Current character: ']'
//        It is a closing bracket, so perform the following actions:
//        Pop the count (3) from countStack.
//        Pop the previous string ("ab") from stringStack.
//        Repeat the current string ("c") by the count (3) and append it to the previous string:
//        repeatedString = "ccc"
//        previousString = "ab"
//        currentString = previousString + repeatedString = "abccc"
//        Iteration 9:
//
//        Current character: ']'
//        It is a closing bracket, so perform the following actions:
//        Pop the count (2) from countStack.
//        Pop the previous string ("") from stringStack.
//        Repeat the current string ("abccc") by the count (2) and append it to the previous string:
//        repeatedString = "abcccabccc"
//        previousString = ""
//        currentString = previousString + repeatedString = "abcccabccc"
//        After iterating through all characters, the final value of currentString is "abcccabccc".
//
//        Output: "abcccabccc"
//
//        In summary, the code follows a stack-based approach to decode the given string by handling the
//        opening and closing brackets and repeating the strings within the brackets. It maintains
//        two stacks to keep track of the counts and previous strings. The iteration processes each character