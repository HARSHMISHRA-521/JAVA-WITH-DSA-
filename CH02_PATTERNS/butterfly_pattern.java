import java.util.*;

//        *             *
//        * *         * *
//        * * *     * * *
//        * * * * * * * *
//        * * * * * * * *
//        * * *     * * *
//        * *         * *
//        *             *
//

public class butterfly_pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of rows(half-body):");
        int n = sc.nextInt();

//        for half of above

//        for stars
        for(int i =1;i<=n;i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }


//        for spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }


//        for stars

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }




        //        for half of below

//        for stars
        for(int i =n;i>=1;i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }


//        for spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }


//        for stars

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
