package CH9_RECURSION;

//time  complexity is O(n)

public class calc_powerOFnum {
    public static int power(int n ,int p){
        if(p==0){
            return 1;
        }
        return n * power(n,p-1);
    }

    public static void main(String[] args) {
        int n =2,pow = 5;
        System.out.println(power(n,pow));
    }
}
