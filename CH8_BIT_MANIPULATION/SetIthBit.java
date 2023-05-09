public class SetIthBit {
    public static int setIthBit(int num, int pos) { // set mean converting the bit into 1
        int bitMask = 1 << pos;
        return num | bitMask;
    }

    public static void main(String[] args) {
        System.out.println(setIthBit(10, 2));  //1010 at pos 2 ,i.e is 0 so output will be 1110 i.e 14
    }
}