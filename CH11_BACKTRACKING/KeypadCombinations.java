package CH11_BACKTRACKING;
//Question 2 :
//        Keypad Combinations
//        Given a string containing digits from 2-9 inclusive, print all possible letter combinations that
//        the number could represent. You can print the answer in any order.
//        A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1
////        does not map to any letters.
//Sample Input 1 : digits = "23"
//        Sample Output 1 : "ad", "ae", "af", "bd", "be", "bf", "cd", "
//        Sample Input 2 : digits = "2"
//        Sample Output 2 : "at "c"
//        Sample Input 3 : digits =
//        Sample Output 3



public class KeypadCombinations {
    // Mapping of digits to letters
    private static final String[] KEYPAD_MAPPING = {
            "",     // 0 doesn't map to any letters
            "",     // 1 doesn't map to any letters
            "abc",  // digit 2 maps to letters 'a', 'b', and 'c'
            "def",  // digit 3 maps to letters 'd', 'e', and 'f'
            "ghi",  // digit 4 maps to letters 'g', 'h', and 'i'
            "jkl",  // digit 5 maps to letters 'j', 'k', and 'l'
            "mno",  // digit 6 maps to letters 'm', 'n', and 'o'
            "pqrs", // digit 7 maps to letters 'p', 'q', 'r', and 's'
            "tuv",  // digit 8 maps to letters 't', 'u', and 'v'
            "wxyz"  // digit 9 maps to letters 'w', 'x', 'y', and 'z'
    };

    private static void generateCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            System.out.println("No digits provided.");
            return; // If the input is empty, return without generating any combinations
        }

        StringBuilder combination = new StringBuilder();
        backtrack(combination, digits, 0); // Call the backtrack function to generate combinations
    }

    private static void backtrack(StringBuilder combination, String digits, int index) {
        // Base case: If we have processed all digits, print the combination
        if (index == digits.length()) {
            System.out.println(combination.toString());
            return;
        }

        char digit = digits.charAt(index); // Get the current digit
        String letters = KEYPAD_MAPPING[digit - '0']; // Get the corresponding letters for the digit
//
//        In Java, characters are represented using Unicode values.The characters '0' to '9' have consecutive Unicode
//        values starting from 48 for '0' and incrementing by 1 for each subsequent digit.In the
//        line String letters = KEYPAD_MAPPING[digit - '0'];,
//        digit - '0' is used to convert the character digit to its corresponding integer value.
//        Since '0' is the starting character for digits, subtracting '0' from any digit character
//        will give its corresponding integer value. For example, '1' - '0' equals 49 - 48, which
//        gives the integer value 1.


        // Iterate through each letter and make a recursive call with the next digit
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            combination.append(letter); // Add the letter to the combination

            // Make a recursive call with the next digit
            backtrack(combination, digits, index + 1);

            combination.deleteCharAt(combination.length() - 1); // Remove the letter for backtracking
        }
    }

    public static void main(String[] args) {
        String digits = "23"; // Example input
        generateCombinations(digits); // Call the function to generate combinations
    }
}

//
//Explanation:
//
//        The KEYPAD_MAPPING array maps each digit from 2 to 9 to the corresponding letters on a telephone keypad.
//        The generateCombinations function serves as the entry point for the program. It takes the input digits and
//        calls the backtrack function to generate combinations.
//        The backtrack function is a recursive function that takes a StringBuilder for the current combination, the
//        input digits, and the current index.
//        In the backtrack function, the base case is when we have processed all digits. At this point, the combination
//        is printed.
//        Inside the backtrack function, the current digit is extracted from the input digits, and the corresponding
//        letters for that digit are retrieved from the KEYPAD_MAPPING.
//        A loop iterates through each letter and adds it to the combination. Then, a recursive call is made
//        with the next digit.
//        After the recursive call, the last letter is removed from the combination using deleteCharAt to perform
//        backtracking.
//        The main function serves as the entry point for the program. It defines an example input string and calls
//        the generateCombinations function to generate combinations for that input.