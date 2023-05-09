import java.util.Scanner;

import java.util.*;
public class inverted_half_pyramid_numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of rows : ");
        int n = sc.nextInt();

//        outer
        for(int i=1;i<=n;i++){
//         inner
            for(int j=1;j<=n-i+1;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

}
