package DAY4;

// tags : Implementation , Sliding-Window , Medium
public class longest_substring_without_repeating_character {
    public int lengthOfLongestSubstring(String s) {
        boolean[] present = new boolean[128];
        int maxLength = 0;

        for (int low = 0, high = 0; high < s.length(); high++) {
            char c = s.charAt(high);
            // if already present character encountered , slide the window until this
            // character gets removed
            if (present[c]) {
                while (s.charAt(low) != s.charAt(high)) {
                    present[s.charAt(low)] = false;
                    low++;
                }
                low++;
            } else {
                present[c] = true;
                maxLength = Math.max(high - low + 1, maxLength);
            }
        }
        return maxLength;
    }
}
