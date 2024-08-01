package CH21_BASIC_MATHAMATICS;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Numberpalindrome {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the number to be checked  : ");
        int num = Sc.nextInt();
        int original = num;
        int rev =0 ;

        while(num>0){
          int lastnum = num%10;
          num = num/10;
          rev = (rev*10)+lastnum;
        }

        if (rev == original) {
            System.out.println("Number is palindrome !");
        }
        else {
            System.out.println("!!!! Number is not palindrome");
        }

    }
}
