package DAY14;

import java.util.*;

// tags: Stack , DataStructures , Hard
public class largest_rectangle_in_a_histogram {
    // the idea is that in the largest histogram area , one bar will have its height
    // equal to length of the histogram
    // now we only need to calculate the width of the rectangle
    // so for each bar find its width ie. the index of the element which is smaller
    // than this height on bothh sides

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n], right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            left[i] = -1;
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()])
                stack.pop();
            if (!stack.isEmpty())
                left[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            right[i] = n;
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()])
                stack.pop();
            if (!stack.isEmpty())
                right[i] = stack.peek();
            stack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++)
            maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * heights[i]);
        return maxArea;
    }
}
