package CH12_ArrayList;   //O(n)
import java.util.*;
//
//Container with Most Water
//        For given n lines on x-axis, use 2 lines to form a container such
//        that it holds maximum water.

public class MostWater_2pointerApproach {
    public static int storeWater(ArrayList<Integer> height){
        int maxwater=0;
        int lp = 0;//left pointer
        int rp = height.size()-1;//right pointer

        while(lp<rp) {
            //calculate water area
            int ht = Math.min(height.get(lp),height.get(rp));
            int width = rp-lp;
            int currArea = ht *width;
            maxwater = Math.max(maxwater,currArea);

            //update ptr
            if(height.get(lp)<height.get(rp)){
                lp++; //move forward
            }else{//height.get(lp)>height.get(rp)
                rp--;//move forward towards left from back(right side)
            }
        }
        return maxwater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        //1,8,6,2,8,5,4,8,3,7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println("max area of water can be stored is " + storeWater(height));
    }
}
