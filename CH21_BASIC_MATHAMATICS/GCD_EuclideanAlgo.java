package CH21_BASIC_MATHAMATICS;

import java.util.Scanner;

public class GCD_EuclideanAlgo {
    // Algo: GCD(a, b) = GCD(a % b, b) where a > b
    // The GCD is found when one of the numbers becomes 0.

    //TC =  log base phi (min(num1,num2)) because its being divided  by the number of times of the min number

    static int GCD(int n1, int n2) {
        if (n1 == 0) {
            return n2;
        } else if (n2 == 0) {
            return n1;
        }

        while (n1 != 0 && n2 != 0) {
            if (n1 > n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }

        return n1 == 0 ? n2 : n1;
    }

    public static void main(String[] args) {
        System.out.println("Enter two numbers: ");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int gcd = GCD(n1, n2);
        System.out.println("GCD of " + n1 + " and " + n2 + " is " + gcd);
    }
}
