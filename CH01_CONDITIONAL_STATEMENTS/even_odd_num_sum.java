// write a program to take the set of integers as input and print the sum of even and odd numbers

import java.util.*;

public class even_odd_num_sum {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int choice ;
        int num;
        int evensum =0;
        int oddsum =0;

        do{
            System.out.println("Enter the number");
            num = sc.nextInt();
            if(num % 2==0){
                evensum+=num;
            }
            else{
                oddsum+=num;
            }

            System.out.println("Enter your choice if you want to continue then press 1 else press 0");
            choice = sc.nextInt();
        }while(choice == 1);

        System.out.println("The sum of EVEN numbers are : "+ evensum);
        System.out.println("The sum of ODD numbers are : "+ oddsum);

    }
}
