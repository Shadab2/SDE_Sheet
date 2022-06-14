package DAY15;

public class longest_palindromic_substring {
    String ans = "";

    // Appraoch #1, any palindromic string will start with some center and for each
    // center we want to maximize same character in sequence on both sides
    // another would be to try for even paldromic string
    public String longestPalindrome(String s) {
        ans = s.charAt(0) + "";
        for (int i = 1; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i - 1);
        }
        return ans;
    }

    public void expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (ans.length() < (j - i - 1))
            ans = s.substring(i + 1, j);

    }

    // appraoch #2 using dynamic programming
    public String longestPalindrome1(String s) {
        String ans = s.charAt(0) + "";
        int n = s.length();
        // dp[i][j] tell whether the substing from i to j is palindrome or not
        boolean dp[][] = new boolean[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        // start from the bottom as to know the value of dp[i][j] , we need values
        // dp[i+1][j-1]
        // dp[i][i] = true , also dp[i][i+1] = true given that s.charAt(i) ==
        // s.charAt(i+1)
        // dp[i][j] = true only if dp[i+1][j-1] = true and s.charAt(i) == s.charAt(j)
        for (int i = n - 2; i >= 0; i--) {
            // start from length uptto maximum length
            for (int len = 1; len < n - i; len++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 1)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > ans.length())
                    ans = s.substring(i, j + 1);
            }
        }
        return ans;
    }
}
