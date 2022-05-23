package DAY7;

import java.util.*;

//tags : Implementation , Sorting, Medium
public class threesum {
    // similart concept like four sum problem
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        // no point for running the loop if we have only positive elements left
        for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    list.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // remove duplicates
                    while (j <= k && nums[j] == nums[j - 1])
                        j++;
                    // remove duplicates
                    while (k >= j && nums[k] == nums[k + 1])
                        k--;
                    ;
                } else if (sum > 0)
                    k--;
                else
                    j++;
            }
            while (i < n - 2 && nums[i + 1] == nums[i])
                i++;
        }
        return list;
    }
}
