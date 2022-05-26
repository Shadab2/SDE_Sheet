package DAY9;

import java.util.*;

public class subsets2 {
    List<List<Integer>> ans = new ArrayList<>();

    // Approach #1 Using Recursion
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        recursive(nums, 0, new ArrayList<>());
        return ans;
    }

    public void recursive(int[] nums, int start, ArrayList<Integer> temp) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        int next = start + 1;
        temp.add(nums[start]);
        recursive(nums, next, temp);
        // don't take current element
        temp.remove(temp.size() - 1);
        // don't call for same elements
        while (next < nums.length && nums[next] == nums[start])
            next++;
        recursive(nums, next, temp);
    }

    // Approach #2 Using Backtracking
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>());
        return ans;
    }

    public void solve(int[] nums, int start, ArrayList<Integer> temp) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            solve(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
