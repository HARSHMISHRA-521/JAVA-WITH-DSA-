import java.util.*;
public class Binary_to_Decimal {
    public static void BinToDec(int bnum) {
        int mynum = bnum;
        int dnum = 0;
        int pow = 0;
        while (bnum > 0) {
            int ldigit = bnum % 10;
            dnum += (int) ( (ldigit * Math.pow(2, pow)));
            pow++;
            bnum /= 10;

        }
        System.out.println("The Decimal number of " + mynum + " is :" + dnum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the binary number :");
        int  bnum = sc.nextInt();
        BinToDec(bnum);
    }
}
