package CH16_GREEDY_ALGO;
import java.util.*;

//Job Sequencing Problem
//        Given an array of jobs where every job has a deadline and profit if the job is finished
//        before the deadline. It is also given that every job takes a single unit of time, so the
//        minimum possible deadline for any job is 1. Maximize the total profit if only one job can
//        be scheduled at a time.
//        Job A = 4, 20
//        Job B = 1, 10
//        Job D: 1, 30
//        Job C :1, 40
//        => ans : C A

public class Job_Sequencing_Problem {
    static class job{
        int deadline;
        int profit;
        int id;

        public job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {

        int jobsInfo[][] = {{4,20},{1,10},{1,40},{1,30}};

        ArrayList<job> jobs = new ArrayList<>();

        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new job(i,jobsInfo[i][0],jobsInfo[i][1]));
        }

        //sorting of objects : descending order
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        for(int i =0;i<jobs.size();i++){
            job curr = jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }

        //print sequence
        System.out.println("Max jobs  =  "+ seq.size());
        System.out.print("Task No. => ");
        for(int i= 0;i<seq.size();i++){
            System.out.print(seq.get(i)+1+" ");
        }
        System.out.println();
    }
}
//output =>  Max jobs  =  2
//           Task No. => 3 1
