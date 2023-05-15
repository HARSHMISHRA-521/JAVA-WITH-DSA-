import java.util.*;
public class Decimal_To_Binary {
    public static void DecToBin(int dnum) {
        int mynum = dnum;
        int bnum = 0;
        int pow = 0;
        while (dnum > 0) {
            int rem = dnum%2;
            bnum += (int) ( (rem * Math.pow(10, pow)));
            pow++;
            dnum /= 2;

        }
        System.out.println("The Decimal number of " + mynum + " is :" + bnum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the decimal number :");
        int  dnum = sc.nextInt();
        DecToBin(dnum);
    }
}
