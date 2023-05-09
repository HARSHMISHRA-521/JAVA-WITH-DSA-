public class fast_exponentiation_code {
    public static int fastExponentiation(int num,int pow){ //O(log n)base 2
        int ans =1;
        while(pow>0){
            if((num & 1)!=0){ //check lsb
                ans*= num;
            }
                num *= num;
                pow=pow>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fastExponentiation(5,3));
    }
}
