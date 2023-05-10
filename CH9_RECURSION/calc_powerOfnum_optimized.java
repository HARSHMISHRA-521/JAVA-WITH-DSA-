package CH9_RECURSION;

//O(log n) time complx

public class calc_powerOfnum_optimized {
    public static int power(int n,int p){
        if(p==0){
            return 1;
        }
        int halfpow = power(n,p/2);
        int halfpowSq = halfpow * halfpow;

        //odd
        if(p %2 !=0){
            halfpowSq *=n;
        }
        return halfpowSq;
    }

    public static void main(String[] args) {
        int n =2,pow = 5;
        System.out.println(power(n,pow));
    }

}
