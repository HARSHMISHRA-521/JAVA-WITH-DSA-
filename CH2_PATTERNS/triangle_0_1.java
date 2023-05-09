import java.util.*;

//        1
//        0 1
//        1 0 1
//        0 1 0 1
//        1 0 1 0 1




public class triangle_0_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows number :");
        int n = sc.nextInt();

        for(int i =1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){                //for i+j = even it is printed 1 or else for odd 0 is printed
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
