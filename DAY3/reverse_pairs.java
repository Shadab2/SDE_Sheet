package DAY3;

public class reverse_pairs {
    int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public void mergeSort(int nums[], int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, r, mid);
    }

    public void merge(int nums[], int l, int r, int mid) {

        // check the pairs of both sorted part before merging them together
        for (int i = l, j = mid + 1; i <= mid; i++) {
            while (j <= r && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            count += (j - (mid + 1));
        }
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int arr1[] = new int[n1];
        int arr2[] = new int[n2];

        for (int i = 0; i < n1; i++)
            arr1[i] = nums[i + l];
        for (int i = 0; i < n2; i++)
            arr2[i] = nums[mid + i + 1];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (arr1[i] > arr2[j])
                nums[k++] = arr2[j++];
            else
                nums[k++] = arr1[i++];
        }
        while (i < n1)
            nums[k++] = arr1[i++];
        while (j < n2)
            nums[k++] = arr2[j++];
    }

}
