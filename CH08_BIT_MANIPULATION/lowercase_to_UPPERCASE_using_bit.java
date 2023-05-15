class lowercase_to_UPPERCASE_using_bit {
    public static void main(String[] args) {
        // Convert lowercase character to uppercase
        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.print((char) (ch & '_')+" ");
        }
        // prints ABCDEFGHIJKLMNOPQRSTUVWXYZ
    }
}
//        In this code, the lowercase character is converted to uppercase
//        using the bitwise AND operator & with the mask '_' (underscore)
//        which has all the bits set to 1 in the positions corresponding to the
//        uppercase letters. The resulting value is then cast to a character using the (char)
//        type-casting. The loop runs for all the lowercase characters from 'a' to 'z' and prints the corresponding uppercase letters.