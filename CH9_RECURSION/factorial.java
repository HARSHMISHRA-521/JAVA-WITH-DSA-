package CH9_RECURSION;
//space and time complexity of the code is O(n)
public class factorial {
    public static int fact(int n){
        if(n == 0){
            return 1;
        }
        if(n!=1) {
            System.out.print(n + " x ");
        }
        else {
            System.out.print(n + " = ");
        }
        int f = n*fact(n-1);
        return f;
    }

    public static void main(String[] args) {
        int n =10;
        System.out.print(fact(n));
    }
}
