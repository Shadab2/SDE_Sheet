package DAY10;

import java.util.*;

// tags: 2D , Backtrack , Medium
public class rat_in_a_maze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        solve(m, 0, 0, n, "", ans);
        return ans;
    }

    public static void solve(int[][] m, int x, int y, int n, String s, ArrayList<String> ans) {
        if (x < 0 || y < 0 || x >= n || y >= n || m[x][y] != 1)
            return;
        if (x == n - 1 && y == n - 1)
            ans.add(s);
        m[x][y] ^= 1;
        solve(m, x + 1, y, n, s + "D", ans);
        solve(m, x, y + 1, n, s + "R", ans);
        solve(m, x - 1, y, n, s + "U", ans);
        solve(m, x, y - 1, n, s + "L", ans);
        m[x][y] ^= 1;
    }
}
