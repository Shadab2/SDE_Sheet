package DAY11;

// tags : BinarySearch , Medium
public class single_element_in_a_sorted_array {

    // any side which has odd elements must have one element missing
    // decide that by binary search
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int count = mid > 0 && nums[mid] == nums[mid - 1] ? mid - 1 : mid;
            if (count % 2 != 0)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return nums[l - 1];
    }
}
