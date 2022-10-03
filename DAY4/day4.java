package DAY4;

import java.util.*;

class fourSum {

    // the idea is to extend two sum problem into four sum problem
    public List<List<Integer>> fourSumSolve(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            int a = nums[i];
            // early exit if we the target is less than current multiples
            if (a > 0 && (long) (a * 4) > target)
                break;
            for (int j = i + 1; j < n - 2; j++) {
                int b = nums[j];
                if (a > 0 && a + b * 3 > target)
                    break;
                long sum = target - (a + b);
                int start = j + 1, end = n - 1;
                while (start < end) {
                    if (nums[start] + nums[end] == sum) {
                        ans.add(List.of(a, b, nums[start], nums[end]));
                        start++;
                        end--;
                        // remove duplicates
                        while (start < end && nums[start] == nums[start - 1])
                            start++;
                        // remove duplicates
                        while (start < end && nums[end] == nums[end + 1])
                            end--;
                    } else if (nums[start] + nums[end] < sum) {
                        start++;
                    } else
                        end--;
                }
                // remove duplicates
                while (j < n - 3 && nums[j] == nums[j + 1])
                    j++;
            }
            // remove duplicates
            while (i < n - 4 && nums[i] == nums[i + 1])
                i++;
        }
        return ans;
    }
}

// ----------------------------------------------------------------------------------------

class largest_subarray_with_zero_sum {
    int maxLen(int arr[], int n) {
        // Your code here
        Map<Integer, Integer> map = new HashMap<>();
        // start with -1 , so to get 1 based length
        // also put 0 to handle case when the length of the subarray of size n resuls in
        // zero sum
        map.put(0, -1);
        int sum = 0, maxLength = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum))
                maxLength = Math.max(i - map.get(sum), maxLength);
            map.putIfAbsent(sum, i);
        }
        return maxLength;

    }
}

// -------------------------------------------------------------------------------------------

class longest_consecutive_sequence {

    // for any longest consecutive subseuqence , the last number in the sequence
    // would be preceeded by any number
    // we will use this fact to construct longest consective seuquence
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums)
            set.add(x);
        int count = 0;
        for (int x : nums) {
            if (!set.contains(x + 1)) {
                int nextCount = 0;
                while (set.contains(x)) {
                    nextCount++;
                    set.remove(x);
                    x--;
                }
                count = Math.max(count, nextCount);
            }
        }
        return count;
    }
}

// --------------------------------------------------------------------------------------

class longest_substring_without_repeating_character {
    public int lengthOfLongestSubstring(String s) {
        boolean[] present = new boolean[128];
        int maxLength = 0;

        for (int low = 0, high = 0; high < s.length(); high++) {
            char c = s.charAt(high);
            // if already present character encountered , slide the window until this
            // character gets removed
            if (present[c]) {
                while (s.charAt(low) != s.charAt(high)) {
                    present[s.charAt(low)] = false;
                    low++;
                }
                low++;
            } else {
                present[c] = true;
                maxLength = Math.max(high - low + 1, maxLength);
            }
        }
        return maxLength;
    }
}

// ---------------------------------------------------------------------------------------------

class subarrays_with_given_xor {
    // just like finding total subarray with given sum B
    public int solve(int[] A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        int count = 0;
        // always put intitial contiditon to test for edge case as first n elements can
        // have xor B
        map.put(xor, 1);
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
            if (map.containsKey(xor ^ B))
                count += map.get(xor ^ B);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}

// -------------------------------------------------------------------------------------------------

class twoSum {
    // there are multiple ways to solve the problem
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.containsKey(target - x))
                return new int[] { map.get(target - x), i };
            map.putIfAbsent(x, i);

        }
        return null;

    }
}

// ------------------------------------------------------------------------------------------------------------