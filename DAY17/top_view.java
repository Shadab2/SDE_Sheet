package DAY17;

import java.util.*;

// just like bottom view 
public class top_view {
    static ArrayList<Integer> topView(TreeNode root) {
        TreeMap<Integer, int[]> tree = new TreeMap<>();
        solve(tree, root, 0, 0);
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] x : tree.values())
            list.add(x[0]);
        return list;
    }

    static void solve(TreeMap<Integer, int[]> tree, TreeNode root, int level, int depth) {
        if (root != null) {
            tree.putIfAbsent(level, new int[] { root.val, depth });
            if (depth < tree.get(level)[1])
                tree.put(level, new int[] { root.val, depth });
            solve(tree, root.left, level - 1, depth + 1);
            solve(tree, root.right, level + 1, depth + 1);
        }
    }
}
