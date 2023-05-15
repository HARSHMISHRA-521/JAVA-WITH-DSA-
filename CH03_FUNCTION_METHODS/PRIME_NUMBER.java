import java.util.*;

public class PRIME_NUMBER {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        if (n == 1){
            System.out.println("This is a neither composite nor a prime number");
        }
        else if(n == 2){
            System.out.println("This is a prime number");
        }
        else {
            boolean pnum = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {// i can be incremented to n/2 or n-1 also ,but this is the best way
                if (n % i == 0) {
                    pnum = false;
                }
            }

            if (pnum == true) {
                System.out.println("The number is  prime");
            } else {
                System.out.println("The number is not prime");
            }
        }
    }
}
