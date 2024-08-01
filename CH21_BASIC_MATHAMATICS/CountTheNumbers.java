package CH21_BASIC_MATHAMATICS;

import java.sql.SQLOutput;
import java.util.Scanner;

import static java.lang.Math.log10;

public class CountTheNumbers {
    /**
     * Here the time complexity is for both is log10(N) ,
     * remember whenever division takes place it runs log of  the base of by which it is being divided.
     * @param args
     */

public static void main(String[] args) {

    //    Basic method
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number : ");
    int number = sc.nextInt();
    int num = number ;
    int counter = 0 ;

    while(number>0){
     counter++;
     number = number/10;

    }

    System.out.println("Number of digits are : " + counter);


    // Another good method is :
    /**
     * As we are diving by the 10 the number and the count is the number of time it can be divided
     * by 10 , so log base 10 of any number also gives that value , so by doing
     * log base 10 of number  + 1 and converting this to int will give the count of the numbers
     */

    int count = (int) (log10 (num) + 1);

    System.out.println("The count of the number is  : " + count );

}


}
