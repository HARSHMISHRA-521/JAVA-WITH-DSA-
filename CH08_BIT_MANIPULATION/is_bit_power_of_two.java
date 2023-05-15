public class is_bit_power_of_two {
    public static boolean isBitPowerOfTwo(int n){
        return (n&(n-1))==0;   // because 2^n & 2^(n-1) == 0
    }

    public static void main(String[] args) {
        System.out.println(isBitPowerOfTwo(16));
    }
}
