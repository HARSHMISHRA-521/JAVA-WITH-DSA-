package CH09_RECURSION;
//its space complexity is O(n)
//its time complexity is exponential ,i.e,O(2^n)

public class fibonacci_recursion {
    public static int fib(int n){
        if(n==0 || n== 1){
            return n;
        }
        int fib = fib(n-1) + fib(n-2);
        return fib;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(fib(n));
    }
}
