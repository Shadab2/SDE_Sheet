package DAY12;

import java.util.*;
// Greedy , Randomized , QuickSelect 

public class kth_largest_number {
    // Approach #1 Brute Force
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : nums)
            pq.add(x);
        while (k-- > 1)
            pq.poll();
        return pq.poll();
    }

    // Approach #2
    // using quick select algorithm with random pivot (most important)
    // try to pick a random pivot shift it to the right most side , use quick sort
    // approach to fit this number to its releavant postion
    // if the position set is kth index , we have found the answer else if posiion >
    // k that means answer lie in the left side and vice versa

    public int findKthLargest1(int[] nums, int k) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int idx = quickSelect(left, right, nums);
            // idx contains kth largest element
            if (idx + 1 == k) {
                return nums[idx];
            }
            // kth largest exists int [idx+1,right]
            if (idx < k) {
                left = idx + 1;
            } else {
                right = idx - 1;
            }
        }

        return -1;
    }

    private int quickSelect(int left, int right, int[] nums) {
        int pivotIdx = getRandom(left, right);
        int pivotVal = nums[pivotIdx];
        swap(nums, pivotIdx, right);

        int beg = left, end = right - 1;

        while (beg <= end) {
            if (nums[beg] > pivotVal) {
                beg++;
            } else {
                swap(nums, beg, end--);
            }
        }

        swap(nums, beg, right);
        return beg;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private int getRandom(int beg, int end) {
        return beg + (int) (Math.random() * (end - beg + 1));
    }
}
