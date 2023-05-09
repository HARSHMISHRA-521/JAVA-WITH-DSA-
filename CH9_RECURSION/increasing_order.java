package CH9_RECURSION;

public class increasing_order {
    public static void printInc(int n){
        //base
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        //inner call
        printInc(n-1);

        System.out.print(n+" ");
    }

    public static void main(String[] args) {
        int n =10;
        printInc(10);
    }
}
