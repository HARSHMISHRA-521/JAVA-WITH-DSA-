package CH21_BASIC_MATHAMATICS;

public class SwapUsingOneLinerXOR {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        System.out.println("Before swap: a = " + a + ", b = " + b);

        // Swap logic
        a = a ^ b ^ (b = a);

        System.out.println("After swap: a = " + a + ", b = " + b);
    }
}
