package DAY1;

// tags : Implementation  , Algorithms , Easy

public class sort_colors {
    // the idea is to maintain a pivot and count and replace every element below and
    // above it
    // trying to put every element greater than pivot above it and every element
    // less than below it
    // which ultimatey puts pivot in its corrent postion
    public void sortColors(int[] nums) {
        int pivot = 1;
        int start = 0, mid = 0, end = nums.length - 1;
        while (mid <= end) {
            if (nums[mid] > pivot)
                swap(nums, mid, end--);
            else if (nums[mid] < pivot)
                swap(nums, start++, mid++);
            else
                mid++;
        }
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
