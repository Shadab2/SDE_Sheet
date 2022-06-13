package DAY14;

import java.util.*;
// tags : Implemntation , Stack;

public class nearest_smallest_element {
    public int[] prevSmaller(int[] A) {
        int ans[] = new int[A.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(A[0]);
        ans[0] = -1;
        for (int i = 1; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= A[i])
                stack.pop();
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(A[i]);
        }
        return ans;
    }
}
