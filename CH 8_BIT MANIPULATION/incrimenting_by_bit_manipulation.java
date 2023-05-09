//Question 3 : Add 1 to an integer usin Bit Manipulation.
//        Hint : try using Bitwise NOT Operator

//Solution 3 : The expression -pex will add 1 to an integer x. We know that to get negative of
//        a number, invert its bits and add 1 to it (Remember negative numbers are stored in 2's
//        complement form), i.e.,
//        - ~ X = X + 1 (by replacing x by ~ x)

public class incrimenting_by_bit_manipulation {
    public static void main(String[] args) {
        int x =6;
        System.out.println(x +" + "+ 1 + " is "+ -~x);
         x =-4;
        System.out.println(x +" + "+ 1 + " is "+ -~x);
         x =0;
        System.out.println(x +" + "+ 1 + " is "+ -~x);
    }
}
