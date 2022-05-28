package DAY11;

// tags : BinarySearch , Hard 
public class median_of_two_sorted_arrays {

    // eg => [1,2,4,5,6] [3,4,6,7,10,100]
    // we partition like this [1,2,4| 5,6] [3,4,6 | 7,10,100]
    // compare 5 and 7 , 5 should be included in the result so incremeant mid toward
    // right
    // compare 4 and 7 , 4 is less so nothing to be done here
    public double median(int a[], int b[]) {
        // choose the one with less elements
        int n1 = a.length, n2 = b.length;
        if (n1 > n2)
            return median(b, a);
        // we approach the problem as we will take every element in the partition before
        // mid1 and mid2
        // we select mid2 such that mid + mid2 = (n1+n2+1)/2

        int low = 0, high = n1;
        // adding 1 to take care of odd length
        int required = (n1 + n2 + 1) / 2;
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = required - mid1;
            // if we select mid1 || mid2 as 0 this means we can not select any element below
            // it
            // so to avoid going below this value we take left values to be the minimum
            // so that left1>right2 || left2>right1 cannot be satisified
            int left1 = mid1 > 0 ? a[mid1 - 1] : Integer.MIN_VALUE;
            int left2 = mid2 > 0 ? b[mid2 - 1] : Integer.MIN_VALUE;
            // if mid1 || mid2 is out of bounds
            // we can not select any right element
            int right1 = mid1 < n1 ? a[mid1] : Integer.MAX_VALUE;
            int right2 = mid2 < n2 ? b[mid2] : Integer.MAX_VALUE;
            if (left1 > right2) {
                high = mid1 - 1;
            } else if (left2 > right1) {
                low = mid1 + 1;
            } else {
                // handle even/odd cases
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
                return (Math.max(left1, left2));
            }
        }
        return 0.0;
    }

}
