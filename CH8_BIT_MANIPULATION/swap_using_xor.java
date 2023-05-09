//Swap two numbers without using any third variable.

//Solution : The idea is to use XOR operators to swap two numbers by their property
//        x XOR x = O
public class swap_using_xor {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        System.out.println("Before swap: x = " + x + " and y = " + y);

        // Swap using XOR operation
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        System.out.println("After swap: x = " + x + " and y = " + y);
    }
}

//Here's how it works:
//
//        Initially, x is assigned the value of 5, and y is assigned the value of 10.
//        The println statement is used to print the values of x and y before the swap.
//        The XOR operation is used to swap the values of x and y.
//        x = x ^ y; XORs the values of x and y and stores the result in x.
//        y = x ^ y; XORs the values of x and y (now stored in x) and stores the result in y.
//        x = x ^ y; XORs the values of x and y (now stored in y) and stores the result in x.
//        The println statement is used again to print the values of x and y after the swap