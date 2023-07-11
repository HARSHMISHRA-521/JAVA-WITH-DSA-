package CH16_GREEDY_ALGO;
import java.util.*;

//Q: Activity Selection
//        You are given n activities with their start and end times. Select the maximum number of activities
//        that can be performed by a single person, assuming that a person can only work on a single
//        activity at a time. Activities are sorted according to end time.
//        start = [10, 12, 20]
//        end =  [20, 25, 30]
//        ans : 2 (AO & A2)

public class Activity_Selection {   // TC: O(n)
    public static void main(String[] args) {
        int start[] ={1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        //end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity
        maxAct =1;
        ans.add(0);
        int lastEnd = end[0];
        for(int i =1;i<end.length;i++){
            if(start[i]>=lastEnd){
                //activity select
                maxAct++;
                ans.add(i);
                lastEnd =end[i];
            }
        }

        System.out.println("max activites = "+maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}
//Output:
//max activites = 4
//A0 A1 A3 A4


// For Case : When the end time is not already sorted ,then we have to code for sorting it too:
//So,here we go with the required changes ->
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//
//public class Activity_Selection {
//    public static void main(String[] args) {
//        int start[] = {0, 1, 3, 5, 5, 8};
//        int end[] = {6, 2, 4, 7, 9, 9};
//
//        // Sorting
//        int activities[][] = new int[start.length][3];
//
//        for (int i = 0; i < start.length; i++) {
//            activities[i][0] = i;
//            activities[i][1] = start[i];
//            activities[i][2] = end[i];
//        }
//
//        // Sort based on end time using lambda function
//        Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));
//        //In java comparator are the interfaces for sorting Java objects
//        //in the above line ,it will sort the 2d array on the basis of the " column 2" in ascending order(o->o[2])
//
//        int maxActivities = 0;
//        ArrayList<Integer> selectedActivities = new ArrayList<>();
//
//        // Select the activities
//        selectedActivities.add(activities[0][0]);
//        int lastEndTime = activities[0][2];
//
//        for (int i = 1; i < end.length; i++) {
//            if (activities[i][1] >= lastEndTime) {
//                maxActivities++;
//                selectedActivities.add(activities[i][0]);
//                lastEndTime = activities[i][2];
//            }
//        }
//
//        System.out.println("Max activities: " + (maxActivities + 1));
//        for (int i = 0; i < selectedActivities.size(); i++) {
//            System.out.print("A" + selectedActivities.get(i) + " ");
//        }
//        System.out.println();
//    }
//}
////output
////Max activities: 4
////        A1 A2 A3 A5
