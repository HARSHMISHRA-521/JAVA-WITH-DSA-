package CH21_BASIC_MATHAMATICS;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PrimeOrNot {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        System.out.println("Enter the number to be checked  : ");
        int num = Sc.nextInt();
        int count =0;

        for(int i=1 ;i*i<=(num);i++){ //better way is (i*i <=num) than Math.sqrt(num)
            if(num%i==0){
                count++;
                if(num/i != i){
                    count++;
                }
            }
        }

        if(count == 2)
        {
            System.out.println("Number is Prime");
        }
        else {
            System.out.println("Number is not Prime");
        }
    }
}
