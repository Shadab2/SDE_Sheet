package DAY2;

// tags : Array , Implementation , Unique , Medium

public class duplicate_number {
    // Approach #1
    // modifying the array so that arr[index] should contains index+1 num , if its'
    // already there more
    // than once return it
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i])
                    return nums[i];
                swap(nums, i, nums[i] - 1);
            } else
                i++;
        }
        return -1;
    }

    public void swap(int arr[], int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    // Approach #2
    // use 0th index to set all numbers to their respective place
    public int findDuplicate1(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int nxt = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = nxt;
        }
        return nums[0];
    }

    // Approach #3
    // floydd warshall , finding cycle start node in the linkedlist
    // imagine every number in the nums as pointer , we have N+1 integers and nums
    // contains integers [1,n]
    // therefore every integer can be pointing to another integer except no one
    // points to first index as 0 is not in the range
    public int findDuplicate3(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
