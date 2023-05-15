public class oddOReven_bit {
    public static void  oddOR_even(int n){
        int bitMask =1;
        if((n & bitMask) == 1){
            //odd
            System.out.println("ODD number");
        }
        else{
            //even
            System.out.println("Even Number");
        }
    }

    public static void main(String[] args) {
        oddOR_even(3);
        oddOR_even(12);
        oddOR_even(0);
    }
}
