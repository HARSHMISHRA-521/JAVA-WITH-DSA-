package CH14_STACK; //O(n)

//Max Area in Histogram
//Given an array of integers heights representing the histogram's bar height where the
//        width of each bar is 1, return the area of the largest rectangle in the histogram.
//        heights :[2,1,5,6,2,3]  ans : 10

import java.util.*;

public class Max_Area_in_Histogram {
    public static void maxArea(int arr[]){  //O(n)-optimized
        int maxArea = 0;
        int nsr[]= new int [arr.length];
        int nsl[]= new int[arr.length];

        //next smaller right = O(n)
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length -1 ;i>=0;i--){ //move from left for right
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length; //only for nsr
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }

        //next smaller left-O(n)
        s = new Stack<>(); // this makes stack empty
        for(int i = 0;i< arr.length;i++){ //move from right for left
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]= -1; //for nsl
            }
            else{
                nsl[i]= s.peek();
            }
            s.push(i);
        }

        //current area : width  =j-i-1 => nsr[i] - nsl[i] -1 -> O(n)
        for(int i = 0;i<arr.length;i++){
            int height= arr[i];
            int width = nsr[i]-nsl[i]-1;
            int currArea = height *width;
            maxArea = Math.max(currArea,maxArea);
        }
        System.out.println("The max area of rectangle in histogram is : "+ maxArea);
    }

    public static void main(String[] args) {
        int arr[] ={2,1,5,6,2,3};
        maxArea(arr); //output : 10
    }
}
