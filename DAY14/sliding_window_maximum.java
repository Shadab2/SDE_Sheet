package DAY14;

import java.util.*;

// tags : Deque , Implementation , Hard
public class sliding_window_maximum {

    // Approach #1
    // using deque gives us the flexibilty to remove and add from both sides
    // to maintain maximum from a window , we always try to add most prominent
    // candidate for the maximum by removing all lower elements
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0, ptr = 0; i < n; i++) {
            // current window start with i-k+1 , any index less than this index is not part
            // of the window
            if (!dq.isEmpty() && i - k + 1 > dq.peek())
                dq.poll();
            // remove all lower elements than the current index , so this way the higher
            // element will always remain in the dq
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            dq.offer(i);
            if (i + 1 >= k)
                ans[ptr++] = nums[dq.peek()];
        }
        return ans;
    }
}
