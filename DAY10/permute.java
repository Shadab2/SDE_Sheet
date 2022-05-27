package DAY10;

import java.util.*;

// tags : Backtracking , Medium
public class permute {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        solve(nums, 0, new ArrayList<>());
        return ans;
    }

    public void solve(int[] nums, int mask, ArrayList<Integer> temp) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) > 0)
                continue;
            temp.add(nums[i]);
            mask ^= (1 << i);
            solve(nums, mask, temp);
            mask ^= (1 << i);
            temp.remove(temp.size() - 1);
        }
    }

}