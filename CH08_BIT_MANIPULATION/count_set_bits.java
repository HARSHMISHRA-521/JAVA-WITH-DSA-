public class count_set_bits {
    public static int noOfsetBits(int n){ //O(log n) as (log n +1 )is the maximum no of bits required to reperesent a number
        int count =0;
        while(n>0){
            if((n&1)!=0){//check lsb bit
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(noOfsetBits(10));
    }
}
