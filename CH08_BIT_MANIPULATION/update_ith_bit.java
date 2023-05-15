public class update_ith_bit {
    public static int clear_IthBit(int num, int pos) { // clear mean converting the bit into 0
        int bitMask = ~(1 << pos);
        return num & bitMask;
    }
    public static int setIthBit(int num, int pos) { // set mean converting the bit into 1
        int bitMask = 1 << pos;
        return num | bitMask;
    }

    public static int updateIthbit(int num,int pos,int newBit){
//        if(newBit ==0){
//            return clear_IthBit(num,pos);
//        }
//        else{
//            return setIthBit(num,pos);
//        }
        //or
        num = clear_IthBit(num,pos);
        int bitMask = newBit<<pos;
        return num | bitMask;

    }

    public static void main(String[] args) {
        System.out.println(updateIthbit(10,2,1));//output 14
    }
}
