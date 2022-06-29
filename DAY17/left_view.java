package DAY17;

import java.util.*;

public class left_view {

    // Appraoch #1 keep count of newly discoverd depths and add them to the list
    // the size of arraylist also corresponds to the depth discovered

    ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        left(root, ans, 0);
        return ans;
    }

    private void left(TreeNode root, ArrayList<Integer> ans, int h) {
        if (root != null) {
            if (h == ans.size())
                ans.add(root.val);
            left(root.left, ans, h + 1);
            left(root.right, ans, h + 1);
        }
    }
}
