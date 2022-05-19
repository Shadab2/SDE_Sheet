package DAY4;

// tags : Implementation , Medium

import java.util.*;

public class fourSum {

    // the idea is to extend two sum problem into four sum problem
    public List<List<Integer>> fourSumSolve(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            int a = nums[i];
            // early exit if we the target is less than current multiples
            if (a > 0 && (long) (a * 4) > target)
                break;
            for (int j = i + 1; j < n - 2; j++) {
                int b = nums[j];
                if (a > 0 && a + b * 3 > target)
                    break;
                long sum = target - (a + b);
                int start = j + 1, end = n - 1;
                while (start < end) {
                    if (nums[start] + nums[end] == sum) {
                        ans.add(List.of(a, b, nums[start], nums[end]));
                        start++;
                        end--;
                        // remove duplicates
                        while (start < end && nums[start] == nums[start - 1])
                            start++;
                        // remove duplicates
                        while (start < end && nums[end] == nums[end + 1])
                            end--;
                    } else if (nums[start] + nums[end] < sum) {
                        start++;
                    } else
                        end--;
                }
                // remove duplicates
                while (j < n - 3 && nums[j] == nums[j + 1])
                    j++;
            }
            // remove duplicates
            while (i < n - 4 && nums[i] == nums[i + 1])
                i++;
        }
        return ans;
    }
}
