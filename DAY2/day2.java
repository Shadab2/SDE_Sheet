package DAY2;

import java.util.*;

class duplicate_number {
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

// ----------------------------------------------------------------------------

class merge_intervals {

    public int[][] merge(int[][] interval) {
        // we need to sort the interval aq to start time in order to always select
        // intervals with smaller start time
        // so that any interval whose starting time is greater than this interval would
        // be merged
        Arrays.sort(interval, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        int[] cur = { interval[0][0], interval[0][1] };
        list.add(cur);

        for (int[] now : interval) {
            // merge
            if (now[0] <= cur[1])
                cur[1] = Math.max(cur[1], now[1]);
            else {
                cur = now;
                list.add(cur);
            }

        }
        // important to specify the size in list.toArray() so to avoid Object cannot to
        // converted to int[]
        return list.toArray(new int[list.size()][2]);
    }
}

// -----------------------------------------------------------------------------

class merge_sorted_array {

    // 0(m+n)
    // the idea is to utilize the idea of merging of two array using the extra n
    // spaces given at the end of first array
    // we need to realize that any circumstance as we are moving from end to start ,
    // no two elements of nums1 will be intersect
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[l--] = nums1[i--];
            else
                nums1[l--] = nums2[j--];
        }
        while (j >= 0)
            nums1[l--] = nums2[j--];
    }

    // O(n^2)
    // place every smallest element in array1 and place the replaced element to its
    // correct position in array2
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0)
            return;
        for (int i = 0; i < m; i++) {
            if (nums1[i] > nums2[0]) {
                nums1[i] ^= nums2[0];
                nums2[0] ^= nums1[i];
                nums1[i] ^= nums2[0];
            }
            int toPlace = nums2[0], j = 1;
            for (; j < n && nums2[j] < toPlace; j++)
                nums2[j - 1] = nums2[j];
            nums2[j - 1] = toPlace;
        }
        for (int i = m; i < m + n; i++)
            nums1[i] = nums2[i - m];
    }
}

// ------------------------------------------------------------------------------

class count_inversions {
    static long count = 0l;

    public static long getInversions(long arr[], int n) {
        // Write your code here.
        mergeSort(arr, 0, n - 1);
        return count;
    }

    public static void merge(long arr[], int l, int r, int mid) {
        int size1 = mid - l + 1;
        int size2 = r - mid;
        long[] arr1 = new long[size1], arr2 = new long[size2];
        for (int i = 0; i < size1; i++)
            arr1[i] = arr[l + i];
        for (int i = 0; i < size2; i++)
            arr2[i] = arr[mid + i + 1];
        int i = 0, j = 0, k = l;
        while (i < size1 && j < size2) {
            if (arr1[i] > arr2[j]) {
                arr[k++] = arr2[j++];
                // at this time we need to add all the remaining elements from arr1
                count += (size1 - i);
            } else
                arr[k++] = arr1[i++];
        }
        while (i < size1) {
            arr[k++] = arr1[i++];
        }
        while (j < size2) {
            arr[k++] = arr2[j++];
        }
    }

    public static void mergeSort(long arr[], int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) >> 1;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, r, mid);
    }

}

// ------------------------------------------------------------------------------

// tags : Impementation , 2D , Maths, Medium
class rotate_image {

    // Approach #1
    // try to rotate each cell individually , observation : let n me the size of the
    // matrix of 1 based indexing
    // x,y -> y,n-x -> n-x ,n-(n-x) -> n-(n-x),n-n-(n-x)
    // max 4 allocations at each rotate
    int n;

    public void rotate(int[][] matrix) {
        n = matrix.length;
        int start = 0, end = n - 1;
        while (start < end) {
            for (int i = start; i < end; i++)
                rotate(i, n - start - 1, 4, matrix[start][i], matrix);
            start++;
            end--;
        }
    }

    public void rotate(int x, int y, int t, int val, int[][] matrix) {
        if (t <= 0)
            return;
        rotate(y, n - x - 1, t - 1, matrix[x][y], matrix);
        matrix[x][y] = val;
    }

    // Approach #2
    // taking the transpose of the matrix and reverse it finally to get 90 deg
    // rotation
    public void rotate1(int[][] matrix) {
        int n = matrix.length;

        // transponse of a matrix
        for (int i = 0; i < n; i++) {
            // start of i+1 to avoid duplicacy
            for (int j = i + 1; j < n; j++)
                swap(matrix, i, j, j, i);
        }

        // reverse the matix;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++)
                swap(matrix, i, j, i, n - j - 1);
        }
    }

    public void swap(int matrix[][], int i, int j, int x, int y) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[x][y];
        matrix[x][y] = temp;
    }
}