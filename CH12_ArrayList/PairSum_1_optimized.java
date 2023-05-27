package CH12_ArrayList; //O(n)
//Pair Sum -1
//        Find if any pair in a Sorted ArrayList has a target sum
//        list [1, 2, 3, 4, 5, 61,

import java.util.*;
public class PairSum_1_optimized {
    public static boolean pairSum(ArrayList<Integer> list,int target){
        int lp= 0;
        int rp = list.size()-1;

        while(lp<rp) { // or(lp!=rp)
            //case 1
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }

            // case 2
            else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            }
            //case 3
            else { //(list.get(lp)+list.get(rp)>target)
                rp--;
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //1,2,3,4,5,6
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(pairSum(list,5));
    }
}
