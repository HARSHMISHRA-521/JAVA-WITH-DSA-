
class  Modular_exponentiation  {
    // Function to calculate (num^pow)%mod in O(log pow)
    static int power(int num, int pow, int mod) {
        int result = 1; // Initialize result

        while (pow > 0) {
            // If pow is odd, multiply num with result
            if ((pow & 1) != 0)
                result = result * num;

            // pow must be even now
            pow = pow >> 1; // pow = pow/2
            num = (num * num) % mod; // Change num to num^2 mod p
        }

        return result % mod;
    }

    public static void main(String[] args) {
        int num = 2; // base
        int pow = 5; // exponent
        int mod = 13; // modulus

        // Compute num^pow mod mod
        int modExp = power(num, pow, mod);

        System.out.print("Result of " + num + "^" + pow + " mod " + mod + " is " + modExp);
    }
}


