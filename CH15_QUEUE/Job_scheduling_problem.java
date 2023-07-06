package CH15_QUEUE;

//Question 3 :
//        Job Sequencing Problem
//        We have an array of jobs where every job has a deadline and associated profit if the job is
//        finished before the deadline. It is also given that every job takes a single unit of time, so the
//        minimum possible deadline for any job is 1. Maximize the total profit if only one job can be
//        scheduled at a time.
//        Sample Input 1
//        JoblD                   Deadline                           Profit
//        a                            4                              20
//        b                            1                             10
//        c                             1                            40
//        d                              1                           30
//
//        Sample Output 1 : c, a

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Overall Time Complexity: O(N log N)
 *
 * Explanation: The dominant factor contributing to the time complexity is the sorting operation performed using
 * the Collections.sort() method, which takes O(N log N) time, where N is the number of jobs. The rest of the
 * operations such as finding the maximum deadline, scheduling the jobs, and printing the scheduled jobs take
 * linear time and do not significantly impact the overall time complexity.
 *
 * Overall Space Complexity: O(maxDeadline)
 *
 * Explanation: The space complexity is determined by the maximum deadline among all the jobs. We use additional
 * space to store the slots array and the scheduledJobs array, both with a size equal to maxDeadline. Therefore,
 * the overall space complexity is O(maxDeadline).
 */

public class Job_scheduling_problem {
    static class Job {
        char id;
        int deadline;
        int profit;

        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        // Create the jobs with their respective deadlines and profits
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job('a', 4, 20));
        jobs.add(new Job('b', 1, 10));
        jobs.add(new Job('c', 1, 40));
        jobs.add(new Job('d', 1, 30));

        // Sort the jobs in descending order of their profits
        Collections.sort(jobs, (j1, j2) -> j2.profit - j1.profit); // TC: O(N log N), SC: O(1)

        // Find the maximum deadline among all jobs
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }
        // TC: O(N), SC: O(1)

        // Initialize an array to keep track of available slots
        boolean[] slots = new boolean[maxDeadline];
        // SC: O(maxDeadline)

        // Initialize an array to store the scheduled jobs
        char[] scheduledJobs = new char[maxDeadline];
        // SC: O(maxDeadline)

        // Schedule the jobs
        for (Job job : jobs) {
            // Find the earliest available slot before the deadline
            int availableSlot = findAvailableSlot(slots, job.deadline);
            // TC: O(deadline)

            // If a slot is available, schedule the job
            if (availableSlot > 0) {
                scheduledJobs[availableSlot - 1] = job.id;
                slots[availableSlot - 1] = true; // Mark the slot as occupied
            }
        }
        // TC: O(N), SC: O(1)

        // Print the scheduled jobs
        System.out.print("Scheduled Jobs: ");
        for (char jobId : scheduledJobs) {
            if (jobId != '\0') {
                System.out.print(jobId + " ");
            }
        }
        // TC: O(maxDeadline), SC: O(1)
    }

    // Function to find the earliest available slot before the deadline
    private static int findAvailableSlot(boolean[] slots, int deadline) {
        // Find the earliest available slot before the deadline
        for (int i = deadline - 1; i >= 0; i--) {
            if (!slots[i]) {
                return i + 1;
            }
        }
        return 0; // No available slot found
    }
    // TC: O(deadline), SC: O(1)
}
