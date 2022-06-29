package DAY17;

import java.util.*;

// observation : the node number of any node given its parent in a complete binary tree is (left)2*n (right)2*n+1
class width_of_a_binary_tree {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 1;
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        map.put(root, 1);
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int first = 1, second = 1;
            for (int i = 0; i < size; i++) {
                TreeNode now = q.poll();
                if (i == 0)
                    first = map.get(now);
                if (i == size - 1)
                    second = map.get(now);
                if (now.left != null) {
                    map.put(now.left, map.get(now) * 2);
                    q.offer(now.left);
                }
                if (now.right != null) {
                    map.put(now.right, map.get(now) * 2 + 1);
                    q.offer(now.right);
                }
            }
            ans = Math.max(ans, second - first + 1);
        }
        return ans;

    }
}