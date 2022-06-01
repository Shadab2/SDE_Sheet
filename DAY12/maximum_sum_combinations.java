package DAY12;

import java.util.*;
// tags: Greedy , Hard

public class maximum_sum_combinations {
    // the idea is to take highest sum which can be formed as per shown
    // [12 34] [34 34] => (1st IndexA + Ist IndexB) , (Ist IndexA + 0thIndexB)
    // so every time we get a max we need to insert IndexA-1,IndexB as well as
    // IndexA,IndexB-1 , provided they are valid
    // also we need to make sure we take unique pair of indices so maintain a set
    // for it

    public int[] solve(int A[], int B[], int C) {
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        Set<String> set = new HashSet<>();
        int ans[] = new int[C];
        int n = A.length;
        set.add(new String((n - 1) + " " + (n - 1)));
        pq.add(new Tuple(A[n - 1] + B[n - 1], n - 1, n - 1));

        for (int i = 0; i < C; i++) {
            Tuple top = pq.poll();
            String idx1 = new String((top.first - 1) + " " + top.second);
            String idx2 = new String((top.first) + " " + (top.second - 1));
            if (top.first > 0 && !set.contains(idx1)) {
                set.add(idx1);
                pq.add(new Tuple(A[top.first - 1] + B[top.second], top.first - 1, top.second));
            }
            if (top.second > 0 && !set.contains(idx2)) {
                set.add(idx2);
                pq.add(new Tuple(A[top.first] + B[top.second - 1], top.first, top.second - 1));
            }
            ans[i] = top.sum;
        }
        return ans;
    }
}

class Tuple implements Comparable<Tuple> {
    int sum;
    int first, second;

    public Tuple(int sum, int first, int second) {
        this.sum = sum;
        this.first = first;
        this.second = second;
    }

    public int compareTo(Tuple that) {
        return that.sum - this.sum;
    }
}