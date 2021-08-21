package DSAprep;

import java.util.*;

/*
*       job sequencing problem:
*           greedy algorithm solution:
*               sort the list of jobs in decreasing order of their profits
*               take an array the size of maxDeadline + 1. [maxDeadline is the largest deadline of any job in the list]
*               for every job, check for an empty slot in the deadline array from the back,
*               i.e start checking from the job's deadline to 0
*                   if an empty slot is available,
*                       that job can be done
*                       add the job to the list of jobs to do
*                       add the profit of the job to the maxProfit
*                       increment the no. of jobs that can be done
*                       finally break
*               display the results
*
*           TC - O(n^2)
*
* */

class job implements Comparable<job>{
    char id;
    int deadline;
    int profit;

    public job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public int compareTo(job that) {
        if (this.profit < that.profit) return 1;
        return -1;
    }
}

public class D8jobSequencing {

    public static void greedy(List<job> jobs, int t) {
        int maxJobs = 0, maxProfit = 0;

//        sort the jobs in the decreasing order of their profits
        Collections.sort(jobs);

//        obtaining the maximum deadline from the list of the jobs
        int maxDeadline = 0;
        for (job j : jobs) {
            if (j.deadline > maxDeadline) maxDeadline = j.deadline;
        }

//        array to keep track of deadlines
        boolean[] deadlines = new boolean[maxDeadline + 1];
        Arrays.fill(deadlines, false);

//   note: we are taking maxDeadline + 1 as the array size because otherwise there will be an IndexOutOfBounds error

//        list to keep track of jobs that can be done
        List<job> jobsThatCanBeDone = new LinkedList<>();

//        iterate over the jobs list
        for (int i = 0; i < jobs.size(); i++) {
//            for every job, check for an empty slot from the deadline of the job to 0, i.e from the end to the start of the array
            for (int j = jobs.get(i).deadline; j > 0; j--) {
//                if an empty slot is found, then we can do that job
//                add the job to the jobs list
//                add the job's profit to the maxProfit
//                increment the no. of jobs that can be done
//                finally, break coz we have found a slot to do the job
                if (!deadlines[j]) {
                    deadlines[j] = true;
                    jobsThatCanBeDone.add(jobs.get(i));
                    maxJobs++;
                    maxProfit += jobs.get(i).profit;
                    break;
                }
            }
        }

//        finally print all the results
        System.out.println("max profit: " + maxProfit);
        System.out.println("max number of jobs that can be done: " + maxJobs);
        for (job j: jobsThatCanBeDone) {
            System.out.print(j.id + "  ");
        }
    }

    public static void main(String[] args) {
        List<job> jobs = new ArrayList();
        jobs.add(new job('a', 4, 20));
        jobs.add(new job('b', 1, 10));
        jobs.add(new job('c', 1, 40));
        jobs.add(new job('d', 1, 30));

        greedy(jobs, 7);
    }
}
