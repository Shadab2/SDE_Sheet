package DAY17;

import java.util.*;

public class path_to_a_given_node {
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        find(A, B, list);
        int n = list.size();
        int ans[] = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = list.get(i);
        return ans;
    }

    public boolean find(TreeNode A, int B, ArrayList<Integer> list) {
        if (A == null)
            return false;
        list.add(A.val);
        if (A.val == B)
            return true;
        if (find(A.left, B, list) || find(A.right, B, list))
            return true;
        list.remove(list.size() - 1);
        return false;
    }
}
