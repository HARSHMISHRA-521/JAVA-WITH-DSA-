package CH09_RECURSION;
//both space and time complexity are O(n)

public class sum_first_n_naturalNo {
    public static int sum(int n){
        if(n == 1){
            return 1;
        }
        if(n!=1) {
            System.out.print(n + " + ");
        }
        else {
            System.out.print(n + " = ");
        }

        int f = n + sum(n-1);

        return f;
    }

    public static void main(String[] args) {
        int n =5;
        System.out.print(sum(n));
    }
}
