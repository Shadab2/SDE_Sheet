package DAY3;

import java.util.*;

class grid_unique_path {

    // Approach #1 bottom-up dp
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

    // Approach #2
    // use the fact that there are m downs and n rights , using m downs and n righs
    // we will reach the last element
    // this is basically (m+n)!/(m!n!)
    // now to be efficiently calculate (m+n)! , we initially divided (m+n)! by
    // smaller n!
    public int uniquePaths1(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        long total = 1;
        if (m < n) {
            m ^= n;
            n ^= m;
            m ^= n;
        }
        for (int i = m, j = 1; i <= m + n - 2; i++, j++) {
            total *= i;
            total /= j;
        }
        return (int) total;
    }
}

// ------------------------------------------------------------------------------

class majority_element {
    public int majorityElement(int[] nums) {
        int freq = 0, m = 0;
        for (int x : nums) {
            if (freq == 0) {
                freq++;
                m = x;
            } else if (x == m)
                freq++;
            else
                freq--;
        }
        return m;
    }
}

// ------------------------------------------------------------------------------------

class majority_elementII {

    // the idea is to extend the majority voting algo for 2 elements as most 2
    // elements can have n/3 freq
    // we will calculate two most significant elements

    public List<Integer> majorityElement(int[] nums) {
        int f1 = 0, f2 = 0, m1 = 0, m2 = 1;
        for (int x : nums) {
            // important to check first for the elements
            // order of if else is very important
            if (x == m1)
                f1++;
            else if (x == m2)
                f2++;
            else if (f1 == 0) {
                f1++;
                m1 = x;
            } else if (f2 == 0) {
                f2++;
                m2 = x;
            } else {
                f1--;
                f2--;
            }
        }
        f1 = f2 = 0;
        // by this time check if two majority elements have freq greater than n/3 or not
        for (int x : nums) {
            if (x == m1)
                f1++;
            else if (x == m2)
                f2++;
        }
        List<Integer> ans = new ArrayList<>();
        if (f1 > nums.length / 3)
            ans.add(m1);
        if (f2 > nums.length / 3)
            ans.add(m2);
        return ans;

    }
}

// -----------------------------------------------------------------------------------------

class powXn {

    // use exponentiation algo
    public double myPow(double x, int n) {
        double res = 1.00;
        int pow = Math.abs(n);
        while (pow != 0) {
            if (pow % 2 != 0) {
                // in negative power we will divide by 1/x
                res = n > 0 ? res * x : res * (1 / x);
                n--;
            }
            pow /= 2;
            x *= x;
        }
        return res;
    }

}

// ----------------------------------------------------------------------------------------------

class reverse_pairs {
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

// ------------------------------------------------------------------------------------