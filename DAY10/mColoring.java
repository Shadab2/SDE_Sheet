package DAY10;

import java.util.*;

public class mColoring {

    // Appraoch #1 Backtracking , 0(m^Vertices) => as every vertices can be colored
    // in m ways
    int M, N;
    int color[];

    public boolean graphColoring(boolean graph[][], int m, int n) {
        M = m;
        N = n;
        color = new int[N];
        return dfs(graph, 0);
    }

    public boolean dfs(boolean graph[][], int src) {
        if (src == N)
            return true;
        for (int clr = 1; clr <= M; clr++) {
            boolean isColorable = true;
            for (int next = 0; next < N && isColorable; next++) {
                if (graph[src][next])
                    isColorable &= color[next] != clr;
            }
            if (isColorable) {
                color[src] = clr;
                if (dfs(graph, src + 1))
                    return true;
                color[src] = 0;
            }
        }
        return false;
    }

    // Approach #2 using BFS O(V+E)
    // will be updated shortly
}
