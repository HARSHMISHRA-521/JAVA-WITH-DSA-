public class clear_last_i_bits {
    public static int clearIbits(int num,int pos){
        int bitMask = (~0)<<pos;
        return num & bitMask;
    }

    public static void main(String[] args) {
        System.out.println(clearIbits(15,2));//output 12
    }
}
