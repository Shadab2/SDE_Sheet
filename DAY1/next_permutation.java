package DAY1;

// tags : Implmentation , Algorithms , Medium
public class next_permutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 2;
        while (i >= 0) {
            // find the first element which is greater than it's following element
            if (nums[i + 1] > nums[i]) {
                int j = n - 1;
                while (j > i && nums[j] <= nums[i])
                    j--;
                // nums[i] should be replaced by an immediate greater element so to assure next
                // permuatation
                swap(nums, i, j);
                break;
            }
            i--;
        }
        // as till ith element the order is maintained as in decreasing order , we
        // should simply
        // reverse it to get the next permuation
        while (++i < --n)
            swap(nums, i, n);
    }

    public void swap(int arr[], int i, int j) {
        int term = arr[i];
        arr[i] = arr[j];
        arr[j] = term;
    }

}
