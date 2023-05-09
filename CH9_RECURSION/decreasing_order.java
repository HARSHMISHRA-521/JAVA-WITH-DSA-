package CH9_RECURSION;

public class decreasing_order {
    public static void printDec(int n){
        //base
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }

    public static void main(String[] args) {
        int n =10;
        printDec(10);
    }
}
