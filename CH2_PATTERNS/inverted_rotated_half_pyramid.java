import java.util.*;
public class inverted_rotated_half_pyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of rows : ");
        int n = sc.nextInt();

//        outer
        for(int i=1;i<=n;i++){
//            for spaces
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
//            for stars
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

}
