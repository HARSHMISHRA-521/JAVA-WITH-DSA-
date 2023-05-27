package CH12_ArrayList;
//
//Container with Most Water
//        For given n lines on x-axis, use 2 lines to form a container such
//        that it holds maximum water.

import java.util.*;
public class Most_water_bruteForce {
    public static int storeWater(ArrayList<Integer> height){  //O(n^2)
        int mostwater =0;
        for(int i =0;i< height.size();i++){
            for(int j=i+1;j< height.size();j++){
                int minheight = Math.min(height.get(i),height.get(j));
                int width =j-i;
                int currStorage = minheight*width;
                mostwater= Math.max(mostwater,currStorage);
            }
        }
        return mostwater;
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
