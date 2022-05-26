package DAY4;

import java.util.*;

public class twoSum {
    // there are multiple ways to solve the problem
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x))
                return new int[] { map.get(target - x), i };
            map.putIfAbsent(x, i);

        }
        return null;

    }
}
