package CH21_BASIC_MATHAMATICS;

import java.util.Scanner;

public class PrintTheAllDivisors {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the number to be checked  : ");
        int num = Sc.nextInt();

        for(int i=1 ;i<=Math.sqrt(num);i++){ //better way is (i*i <=num)
            if(num%i==0){
                System.out.println(i);
                if(num/i != i){
                    System.out.println(num/i);
                }
            }

        }

    }
}
