package DAY16;

public class minimum_characters_required_to_make_string_palindrome {
    // Approach #1 0(n^2) brute force to compute longest string which is palindrome
    // from the 0th index to jth index
    public static int solve(String A) {
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            max = Math.max(max, expand(A, i, i));
            if (i > 0)
                max = Math.max(max, expand(A, i - 1, i));
        }
        return A.length() - max;
    }

    public static int expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    // Approach #2 using lps array
    // Observation if the string is reversed the palindrome part will not be
    // affected , when concateneted with orignial string , the longest common prefix
    // will the length tell us that the longest palindrome present in the string
    // starting with 0th index
    public static int[] lps(String s) {
        int n = s.length(), j = 1, len = 0;
        int[] lps = new int[n];
        lps[0] = 0;
        while (j < n) {
            if (s.charAt(j) == s.charAt(len))
                lps[j++] = ++len;
            else if (len > 0)
                len = lps[len - 1];
            else
                j++;
        }
        return lps;
    }

    public static int solve1(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.append('$');
        for (int i = s.length() - 1; i >= 0; i--)
            sb.append(s.charAt(i));
        System.out.println(sb);
        int[] lps = lps(sb.toString());
        return s.length() - lps[sb.length() - 1];
    }

    public static void main(String[] args) {
        String s = "AABAAB";
        solve(s);
        System.out.println(solve1(s));
    }

}
