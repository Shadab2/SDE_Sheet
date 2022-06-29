package DAY17;

import java.util.*;

public class vertical_traversal {
    // give depth and vertical value to each node , for the root node vertical value
    // be 0 , taking left side vertical value decrease by 1 and vice versa on right
    // side
    TreeMap<Integer, PriorityQueue<int[]>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        solve(root, 0, 0);
        List<List<Integer>> list = new ArrayList<>();
        for (int x : map.keySet()) {
            PriorityQueue<int[]> pq = map.get(x);
            List<Integer> temp = new ArrayList<>();
            while (!pq.isEmpty())
                temp.add(pq.poll()[1]);
            list.add(temp);
        }
        return list;
    }

    public void solve(TreeNode root, int depth, int vertical) {
        if (root != null) {
            if (!map.containsKey(vertical)) {
                PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        if (a[0] != b[0])
                            return a[0] - b[0];
                        return a[1] - b[1];
                    }
                });
                map.put(vertical, pq);
            }
            map.get(vertical).add(new int[] { depth, root.val });
            solve(root.left, depth + 1, vertical - 1);
            solve(root.right, depth + 1, vertical + 1);
        }
    }
}
