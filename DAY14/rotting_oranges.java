package DAY14;

import java.util.*;

// tags : BFS , Medium
public class rotting_oranges {
    // Appraoch #1 The idea is to start bfs from every rotten oranges
    public int orangesRotting(int[][] grid) {
        // (i,i+1) => determines (newx,newy) i<4
        int[] DIRS = new int[] { 0, 1, 0, -1, 0 };
        int m = grid.length;
        int n = grid[0].length;
        int remainFreshOrange = 0;
        // Using Pair will increase the time in packing and unpacking objects , instead
        // use array
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 2) {
                    q.offer(new int[] { r, c });
                    grid[r][c] = 0;
                } else if (grid[r][c] == 1) {
                    remainFreshOrange += 1;
                }
            }
        }
        int steps = 0;
        while (!q.isEmpty() && remainFreshOrange > 0) {
            steps += 1;
            // update the level of bfs without using extra space
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for (int i = 0; i < 4; i++) {
                    int nr = r + DIRS[i];
                    int nc = c + DIRS[i + 1];
                    if (nc < 0 || nr < 0 || nr == m || nc == n || grid[nr][nc] != 1) {
                        continue;
                    }
                    // mark the grid[nr][nc] , so we dont visit this cell again
                    grid[nr][nc] = 0;
                    remainFreshOrange -= 1;
                    q.offer(new int[] { nr, nc });
                }
            }
        }
        return (remainFreshOrange > 0) ? -1 : steps;
    }
}
