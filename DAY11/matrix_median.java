package DAY11;
// tags : BinarySearch , Medium

public class matrix_median {

    public int findMedian(int[][] A) {
        // do a binary Search for taking median candidate among [1,1e9]
        int low = 1, high = (int) 1e9;
        int total = A[0].length * A.length;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int count = 0;
            for (int x[] : A)
                count += count(x, mid);
            if (count <= total / 2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    // do a binary Search for counting elements greater than X
    public int count(int[] a, int x) {
        int l = 0, r = a.length - 1;
        if (x < a[l])
            return 0;
        if (a[r] <= x)
            return a.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (a[mid] <= x)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}
