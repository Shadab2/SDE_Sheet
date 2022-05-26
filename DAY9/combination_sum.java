package DAY9;

import java.util.*;

// tags : Backtracking , Medium

public class combination_sum {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] ca, int target) {
        solve(ca, target, new ArrayList<>(), 0);
        return ans;
    }

    public void solve(int[] ca, int target, List<Integer> temp, int start) {
        if (target < 0 || start == ca.length)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < ca.length; i++) {
            int x = ca[i];
            if (target - x >= 0) {
                temp.add(x);
                solve(ca, target - x, temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
