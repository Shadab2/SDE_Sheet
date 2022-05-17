package DAY2;

// tags : Implementation , Sorting , Easy

public class merge_sorted_array {

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
