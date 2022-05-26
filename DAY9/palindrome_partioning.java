package DAY9;

import java.util.*;

// tags : Backtrack  , Medium
public class palindrome_partioning {
    List<List<String>> ans = new ArrayList<>();

    // the idea is to recursively check the prefix of the current string is a valid
    // palindrome or not
    // then check for the remaining substring

    public List<List<String>> partition(String s) {
        solve(s, new ArrayList<>());
        return ans;
    }

    public void solve(String s, List<String> temp) {
        if (s.length() == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int next = 0; next < s.length(); next++) {
            String pre = s.substring(0, next + 1);
            if (isPalindrome(pre)) {
                temp.add(pre);
                solve(s.substring(next + 1), temp);
                temp.remove(temp.size() - 1);
            }
        }

    }

    public boolean isPalindrome(String s) {
        int i = -1, j = s.length();
        while (++i < --j)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }

    public static void main(String[] args) {

    }
}
