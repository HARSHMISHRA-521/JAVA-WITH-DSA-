//       uestion 4 : Determine if 2 Strings are anagrams of each other.
//        hat are anagrams?
//        f two strings contain the same characters but in a different order, they can be said to be
//        nagrams. Consider race and care. In this case, race's characters can be formed into a study,
//        r care's characters can be formed into race. Below is a java program to check if two strings
//        re anagrams or not.

import java.util.Arrays;

class anagram{
    public static void main(String[] args) {
        String str1 = "earth";
        String str2 = "heart";

        // Convert strings to lowercase separately
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // First check the length: are they the same?
        if (str1.length() != str2.length()) {
            System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
        } else {
            // Convert strings to char arrays
            char[] str1CharArray = str1.toCharArray();
            char[] str2CharArray = str2.toCharArray();

            // Sort the char arrays
            Arrays.sort(str1CharArray);
            Arrays.sort(str2CharArray);

            // Check if the sorted char arrays are the same or identical
            boolean result = Arrays.equals(str1CharArray, str2CharArray);

            // Print the result
            if (result) {
                System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
            }
        }
    }
}


