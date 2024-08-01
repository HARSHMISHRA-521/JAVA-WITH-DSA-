package CH21_BASIC_MATHAMATICS;

import java.util.Scanner;

public class ReverseTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to be reversed : ");
        int n= sc.nextInt();
        int rev =0;

        while(n>0){
            int lastNum = n%10;
            n = n/10;
            rev = (rev*10)+lastNum;
        }

        System.out.println("the reverse number is : "+ rev);
    }
}
