import java.util.*;

public class hollow_square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows :");
        int row = sc.nextInt();
        System.out.println("Enter the number of column :");
        int col = sc.nextInt();
               //        outer loop
        for(int i=1;i<=row;i++){
                //            for inner column
            for(int j =1;j<=col;j++){
                if(i==1|| i==row|| j==1||j==col){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
