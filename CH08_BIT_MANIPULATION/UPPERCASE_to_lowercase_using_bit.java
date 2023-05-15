class UPPERCASE_to_lowercase_using_bit {
    public static void main(String[] args) {
        // Convert uppercase character to lowercase
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print((char) (ch | ' ')+" "); //by doing or with space
        }
        // prints abcdefghijklmnopqrstuvwxyz
    }
}
