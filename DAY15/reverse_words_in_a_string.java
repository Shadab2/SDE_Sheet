package DAY15;

import java.util.Arrays;
import java.util.Collections;

public class reverse_words_in_a_string {
    // Approach #1 using extra space
    public String reverseWords(String s) {
        String temp[] = s.split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = temp.length - 1; i >= 0; i--) {
            sb.append(temp[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    // Concise solution
    public String reverseWords1(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    // Approach #3 space-optimized solution
    public String reverseWords3(String s) {
        StringBuilder sb = new StringBuilder("");
        StringBuilder ans = new StringBuilder("");
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (sb.length() == 0)
                    continue;
                ans.append(sb.reverse());
                ans.append(" ");
                sb = new StringBuilder("");
            } else
                sb.append(s.charAt(i));
        }
        if (sb.length() > 0)
            ans.append(sb.reverse());
        return ans.toString().trim();
    }

}
