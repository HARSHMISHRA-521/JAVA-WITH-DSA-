public class clear_bits_in_range {
    public static int clearBitsInRange(int n,int i,int j){
        int a = ((~0)<<(j+1));
        int b =(1<<i)-1;
        int bitMask = a|b;
        return n & bitMask;
    }

    public static void main(String[] args) {
        System.out.println(clearBitsInRange(10,2,4)); // 10 = 0001010 ,i=2,j=4 ,result = 0000010 =(2)10
    }
}
