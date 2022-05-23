package DAY7;

// tags : Implemnetation , Easy
public class remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++)
            if (nums[i] != nums[j])
                nums[++i] = nums[j];
        return i + 1;
    }
}
