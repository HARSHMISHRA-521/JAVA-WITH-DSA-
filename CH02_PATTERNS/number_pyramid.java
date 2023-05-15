import java.util.*;
//                       1
//                      2  2
//                     3  3  3
//                    4  4  4  4
//                   5  5  5  5  5

public class number_pyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of rows :");
        int n = sc.nextInt();

        for(int i =1;i<=n;i++){
            for (int j= 1;j<=n-i;j++){
                System.out.print("  ");
            }

            for(int j=1;j<=i;j++){
                System.out.print(i+"  ");
            }
            System.out.println();
        }

    }
}
