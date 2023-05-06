public class clearIthBit {
    public static int clear_IthBit(int num, int pos) { // clear mean converting the bit into 0
        int bitMask = ~(1 << pos);
        return num & bitMask;
    }

    public static void main(String[] args) {
        System.out.println(clear_IthBit(10, 1));  //1010 at pos 1 ,i.e is 1 so output will be 1000 i.e 8
    }
}
