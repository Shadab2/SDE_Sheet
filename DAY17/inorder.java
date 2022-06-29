package DAY17;

import java.util.*;;

public class inorder {
    // inorder => left ,root, right
    // Approach #1 Iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderRecursion(root, list);
        return list;
    }

    public void inorderRecursion(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorderRecursion(root.left, list);
            list.add(root.val);
            inorderRecursion(root.right, list);
        }
    }
}
