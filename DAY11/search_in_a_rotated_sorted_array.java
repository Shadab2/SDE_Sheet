package DAY11;

// tags : BinarySearch , Medium
public class search_in_a_rotated_sorted_array {
    // first we need to search for the index which would be first index if array
    // were not rotated
    // observe that if we do binary search lets say [3 4 5 1 2] arr[mid]>arr[r]
    // indicating that there must be an index of the first index
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = -1;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[r] > nums[mid])
                r = mid;
            else
                l = mid + 1;
        }
        int rotate = r, rotatedMid = 0;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            mid = (l + r) / 2;
            rotatedMid = (mid + rotate) % nums.length;
            if (nums[rotatedMid] == target)
                return rotatedMid;
            if (nums[rotatedMid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}
