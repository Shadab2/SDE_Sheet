package DAY17;

import java.util.*;;

public class bottom_view {
    // Approach #1 using TreeMap
    public ArrayList<Integer> bottomView(TreeNode root) {

        TreeMap<Integer, int[]> tree = new TreeMap<>();
        solve(tree, root, 0, 0);
        ArrayList<Integer> list = new ArrayList<>();
        for (int x : tree.keySet())
            list.add(tree.get(x)[1]);
        return list;
    }

    public void solve(TreeMap<Integer, int[]> tree, TreeNode root, int depth, int vertical) {
        if (root != null) {
            if (!tree.containsKey(vertical))
                tree.put(vertical, new int[] { depth, root.val });
            else {
                int[] p = tree.get(vertical);
                if (p[0] <= depth)
                    tree.replace(vertical, new int[] { depth, root.val });
            }
            solve(tree, root.left, depth + 1, vertical - 1);
            solve(tree, root.right, depth + 1, vertical + 1);
        }
    }

    // Approach #2 using bfs

}
