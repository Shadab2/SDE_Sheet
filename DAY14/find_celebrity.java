package DAY14;

import java.util.*;

public class find_celebrity {

    // Approach #1 using Stack
    // Pick the top two people from the stack and check which can be a potential
    // candidate for the celbrity
    int celebrity(int M[][], int n) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            dq.push(i);
        while (dq.size() > 1) {
            int first = dq.pop();
            int second = dq.pop();
            if (M[first][second] == 0)
                dq.push(first);
            else
                dq.push(second);
        }
        if (dq.size() == 0)
            return -1;
        int last = dq.pop();
        for (int i = 0; i < n; i++) {
            if (i == last)
                continue;
            // If last candidate known anyone or any candidate doesn't know last then no
            // answer
            if (M[last][i] == 1 || M[i][last] == 0)
                return -1;
        }
        return last;
    }

    // Approach #2 Two-pointers
    int celebrity1(int M[][], int n) {
        int start = 0, end = n - 1;
        // if start knows end , then end must be a candidate for celbrity otherwise
        // start
        while (start < end) {
            if (M[start][end] == 1)
                start++;
            else
                end--;
        }
        for (int i = 0; i < n; i++) {
            if (i == start)
                continue;
            if (M[start][i] == 1 || M[i][start] == 0)
                return -1;
        }
        return start;
    }
}
