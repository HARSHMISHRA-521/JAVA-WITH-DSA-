import java .util.*;
//                  1
//                 212
//                32123
//               4321234
//              543212345
//
//

public class PALINDROMIC_PATTERN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of rows : ");
        int n = sc.nextInt();
        //for rows
        for(int i=1;i<=n;i++){

            //for spaces
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            //for desc
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            //for asce
            for(int j=2;j<=i;j++){
                System.out.print(j);
            }

            System.out.println();
        }
    }
}
