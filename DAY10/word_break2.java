package DAY10;

import java.util.*;

// tags: Backtracking , Hard
public class word_break2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<String> ans = new ArrayList<>();
        attach(s, wordDict, 0, ans, new StringBuilder());
        return ans;
    }

    public void attach(String s, List<String> wordDict, int i, List<String> ans, StringBuilder sb) {
        if (i == s.length()) {
            ans.add(sb.toString().trim());
            return;
        }
        // take words only if they are in the wordDict and recurse for rest
        for (int j = i; j < s.length(); j++) {
            String temp = s.substring(i, j + 1);
            if (wordDict.contains(temp)) {
                sb.append(temp);
                sb.append(" ");
                attach(s, wordDict, j + 1, ans, sb);
                sb.replace(sb.length() - temp.length() - 1, sb.length(), "");
            }
        }
    }
}
