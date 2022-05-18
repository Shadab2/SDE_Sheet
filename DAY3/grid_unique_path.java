package DAY3;

// tags : DP , Implementation , Maths , Medium
public class grid_unique_path {

    // Approach #1 bottom-up dp
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    // Approach #2
    // use the fact that there are m downs and n rights , using m downs and n righs
    // we will reach the last element
    // this is basically (m+n)!/(m!n!)
    // now to be efficiently calculate (m+n)! , we initially divided (m+n)! by
    // smaller n!
    public int uniquePaths1(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        long total = 1;
        if (m < n) {
            m ^= n;
            n ^= m;
            m ^= n;
        }
        for (int i = m, j = 1; i <= m + n - 2; i++, j++) {
            total *= i;
            total /= j;
        }
        return (int) total;
    }
}
