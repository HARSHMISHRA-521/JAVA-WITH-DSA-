package CH21_BASIC_MATHAMATICS;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the number to be checked  : ");
        int num = Sc.nextInt();
        int original = num;
        int sum =0 ;

        while(num>0){
           int n = num %10;
            num = num /10;
            sum = (int) (sum + Math.pow(n,3));
        }

        if (sum == original) {
            System.out.println("It's an Armstrong Number ! ");
        }
        else {
            System.out.println("!!! It's not an Armstrong Number ");
        }
    }
}
