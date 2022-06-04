package DAY13;

import java.util.*;

// tags : Stack , Implementation , Map , Easy
public class next_greater_element {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        // store every number whose greater element is found in map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i])
                stack.pop();
            if (!stack.isEmpty())
                map.put(nums2[i], stack.peek());
            stack.push(nums2[i]);
        }
        // use this map if the value is already calculated or give the result -1 by
        // default
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
