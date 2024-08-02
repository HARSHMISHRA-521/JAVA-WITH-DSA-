package CH21_BASIC_MATHAMATICS;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers  : ");
        int n1 = sc.nextInt();
        int n2 =sc.nextInt();

        for (int i = Math.min(n1,n2);i>0;i--){
            if( n1%i ==0 && n2%i ==0){
                System.out.println("GCD of "+n1 + " and "+ n2 +" is "+ i);
                break;
            }
        }
    }
}
