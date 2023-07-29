package CH16_GREEDY_ALGO;
//Question 1 .
//        Maximum Balanced String Partitions
//        We have balanced string str of size N with an equal number of L and R, the task is to find a
//        maximum number X, such that a given string can be partitioned into X balanced substring. A
//        string is called to be balanced if the number of L's in the string equals the number of 'R's.
//        Input : "LRRRRLLRLLRL"
//        Output
//        :3

import java.util.*;
public class Maximum_Balanced_String_Partition {   // TC =o(n)  SC = o(1)
    static int BalancedString(String str,int n){
        if(n==0){
            return 0;
        }
        int l=0,r=0;
        int ans =0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)=='L'){
                l++;
            } else if (str.charAt(i)=='R') {
                r++;
            }
            if(r==l){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str= "LLRRRLLRRRL";
        int n = str.length();
        System.out.println("The no. of possible pairs are : ");
        System.out.println(BalancedString(str,n));
    }
}
//output=> The no. of possible pairs are :
//         3