package DAY9;

import java.util.*;

// tags : Backtracking , BruteForce , Medium
public class combination_sum_2 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        solve(candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    public void solve(int[] candidates, int target, List<Integer> list, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // remove duplicate cases
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            // only call recursion when there is a possibility of the answer
            if (target - candidates[i] >= 0) {
                list.add(candidates[i]);
                solve(candidates, target - list.get(list.size() - 1), list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
