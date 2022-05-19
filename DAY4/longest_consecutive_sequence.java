package DAY4;

import java.util.*;

// tags : Implementation , Observation , Medium
public class longest_consecutive_sequence {

    // for any longest consecutive subseuqence , the last number in the sequence
    // would be preceeded by any number
    // we will use this fact to construct longest consective seuquence
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums)
            set.add(x);
        int count = 0;
        for (int x : nums) {
            if (!set.contains(x + 1)) {
                int nextCount = 0;
                while (set.contains(x)) {
                    nextCount++;
                    set.remove(x);
                    x--;
                }
                count = Math.max(count, nextCount);
            }
        }
        return count;
    }
}
