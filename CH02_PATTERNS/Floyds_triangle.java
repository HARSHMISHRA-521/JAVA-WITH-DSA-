import java.util.Scanner;

//       1
//       2  3
//       4  5  6
//       7  8  9  10
//       11 12 13 14 15




public class Floyds_triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of rows : ");
        int n = sc.nextInt();
        int c= 1;

//        outer
        for(int i=1;i<=n;i++){
//         inner
            for(int j=1;j<=i;j++){
                if(c<=10){
                    System.out.print(c+"  ");
                }
                else{
                    System.out.print(c+" ");
                }
                c++;
            }
            System.out.println();
        }
    }

}
