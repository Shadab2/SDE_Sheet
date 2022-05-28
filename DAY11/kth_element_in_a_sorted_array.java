package DAY11;

// tags : BinarySearch, Hard
public class kth_element_in_a_sorted_array {
    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        if (m > n)
            return kthElement(arr2, arr1, m, n, k);
        // its important to set low to value k-m , to avoid overflows ,similarily high
        // to min of k,n
        int low = Math.max(0, k - m), high = Math.min(k, n);
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = k - mid1;
            int l1 = mid1 > 0 ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = mid1 < n ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < m ? arr2[mid2] : Integer.MAX_VALUE;
            if (l1 > r2)
                high = mid1 - 1;
            else if (l2 > r1)
                low = mid1 + 1;
            else
                return Math.max(l1, l2);
        }
        return 0;
    }
}
