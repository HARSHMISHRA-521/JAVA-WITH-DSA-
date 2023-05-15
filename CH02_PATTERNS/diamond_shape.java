import java.util.*;

//                                      *
//                                    * * *
//                                  * * * * *
//                                * * * * * * *
//                              * * * * * * * * *
//                              * * * * * * * * *
//                                * * * * * * *
//                                  * * * * *
//                                    * * *
//                                      *
//


public class diamond_shape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of lines :");
        int n = sc.nextInt();

        //for half
        for(int i =1;i<=n;i++){
//for spaces
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
//for stars
            for(int j =1;j<=2*i-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }



        //for half
        for(int i =n;i>=1;i--){
//for spaces
            for(int j=1;j<=n-i;j++){
                System.out.print("  ");
            }
//for stars
            for(int j =1;j<=2*i-1;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
