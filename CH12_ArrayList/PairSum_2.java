package CH12_ArrayList; //O(n)
//Pair Sum -2
//        Find if any pair in a Sorted & Rotated ArrayList has a target sum
//        list [11, 15, 6, 8, 9, 10], target-16

import java.util.ArrayList;

public class PairSum_2 {
    public static boolean pairSum(ArrayList<Integer> list,int target){
        int bp =-1; //break point
        int n = list.size();
        for(int i = 0;i< list.size();i++){
            if(list.get(i)>list.get(i+1)){
                bp =i ;  //break point
                break;
            }
        }
        int lp = bp+1; // smallest
        int rp = bp;//largest
        while(lp!=rp){
            //case 1
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            //case 2
            else  if(list.get(lp)+list.get(rp)<target){
                lp = (lp+1)%n;  //rotational incremnetation
            }
            else{
                rp= (n+rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//        [11, 15, 6, 8, 9, 10]
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(pairSum(list,25));
    }
}
