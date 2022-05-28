package DAY11;

// tags : BinarySearch , Medium
public class nthRoot_of_a_number {
    // for any x , the nth root lets say y , we can have x = y*y*y...upto n times
    // using this idea we will choose y by binary search and see if the range
    // between lower and upper
    // doesn't exceed the prcesion range that is 1e-6 given

    public static double findNthRootOfM(int n, long m) {
        // Write your code here.
        double l = 1.0, r = 1.0 * m;
        while ((r - l) > 1e-6) {
            double mid = (l + r) / 2.0;
            double ans = 1.0;
            for (int i = 1; i <= n; i++)
                ans *= mid;
            // optimize search space by reducing one half
            // we dont need to increment/decrement mid by 1 , mid/2 will always lead newer
            // mid , and it will not produce erroneuos result
            if (ans > m)
                r = mid;
            else
                l = mid;
        }
        return l;

    }
}
