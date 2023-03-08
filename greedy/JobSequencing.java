package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    static class Job {
        int profit;
        int deadline;
        int id;

        public Job(int p, int d, int i) {
            profit = p;
            deadline = d;
            id = i;
        }
    }

    public static void main(String[] args) {
        int jobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 30 }, { 1, 40 } };

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(jobInfo[i][1], jobInfo[i][0], i));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);// descending order
        // for ascending order just interchange positions of a.profit and b.profit
        int time = 0;
        ArrayList<Integer> seq = new ArrayList<>();
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (time < curr.deadline) {
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Max Jobs: " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }

    }
}
