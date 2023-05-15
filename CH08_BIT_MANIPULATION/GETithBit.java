public class GETithBit {
    public static int getIthBit(int num ,int pos){
        int bitMask = 1<<pos;
        if((num & bitMask)== 0){
            return 0;
        }
        else{
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(getIthBit(10,1));
        System.out.println(getIthBit(8,3));
    }
}
