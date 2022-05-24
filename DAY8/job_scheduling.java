package DAY8;

import java.util.*;

//tags : Greedy , Medium 
public class job_scheduling {

    // since we need to maximize profit , we will consider highest profits first and
    // trying to give them
    // allocation in given deadlines , we will always fill the highest deadlines
    // first and gradually decrementing the deadlines

    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        boolean deadline[] = new boolean[101];
        int jobs = 0, profit = 0;
        for (int i = 0; i < n; i++) {
            int j = arr[i].deadline;
            // while there is space already alocated , move below
            while (j > 0 && deadline[j])
                j--;
            if (j < 1)
                continue;
            deadline[j] = true;
            jobs++;
            profit += arr[i].profit;
        }
        return new int[] { jobs, profit };
    }
}

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
