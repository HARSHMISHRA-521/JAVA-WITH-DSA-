package CH21_BASIC_MATHAMATICS;

import java.util.Scanner;

public class StringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String to be checked: ");
        String str = sc.nextLine();
        sc.close(); // Close the scanner to avoid resource leaks

        boolean isPalindrome = true; // Initialize a flag

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isPalindrome = false; // Set flag to false if characters don't match
                break; // No need to check further if a mismatch is found
            }
        }

        if (isPalindrome) {
            System.out.println("String is a palindrome!");
        } else {
            System.out.println("String is not a palindrome.");
        }
    }
}
