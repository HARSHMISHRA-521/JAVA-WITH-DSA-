package CH16_GREEDY_ALGO;

//COLLEGE
//        Chocola Problem
//        We are given a bar of chocolate composed of mxn square pieces. One should break the chocolate
//        into single squares. Each break of a part of the chocolate is charged a cost expressed by a positive
//        integer. This cost does not depend on the size of the part that is being broken but only depends on
//        the line the break goes along. Let us denote the costs of breaking along consecutive vertical lines
//        with xl, x2, ..., xm-l and along horizontal lines with yl, y2, ..., yn-l.
//        Compute the minimal cost of breaking the whole chocolate into single squares.

import java.util.*;
public class Chocola_Problem {
    public static void main(String[] args) {
        int n =4,m=6;
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};
        Arrays.sort(costVer,Collections.reverseOrder());
        Arrays.sort(costHor,Collections.reverseOrder());
        int v =0,h=0;
        int hp=1,vp=1;
        int cost= 0;

        while(h<costHor.length && v<costVer.length){
            if(costVer[v]<=costHor[h]){ //horizontal cut
                cost+= (costHor[h]*vp);
                h++;
                hp++;
            }
            else{                  //vertical cut
                cost+= (costVer[v]*hp);
                vp++;
                v++;
            }
        }
        while(h<costHor.length){
            cost+= (costHor[h]*vp);
            hp++;
            h++;
        }
        while(v<costVer.length){
            cost+= (costVer[v]*hp);
            vp++;
            v++;
        }
        System.out.println("The total cost for cutting all pieces is =  "+ cost);
    }
}
//output => The total cost for cutting all pieces is =  42