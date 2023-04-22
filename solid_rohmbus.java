import java.util.*;

//                      * * * *
//                    * * * *
//                   * * * *
//                 * * * *
//               * * * *


public class solid_rohmbus {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the no of lines :");
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            //spaces
            for(int j =1;j<=n-i;j++){
                System.out.print("  ");
            }

            //stars
            for(int j=1;j<n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
