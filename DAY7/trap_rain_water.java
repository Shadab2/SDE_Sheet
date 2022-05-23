package DAY7;

// tags: Unique , Alogithmic , Stack , Hard

public class trap_rain_water {

    // Approach #1
    // the idea to take minimum greater height from either side
    // this can be implementated by stack also
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n], right = new int[n];
        right[n - 1] = height[n - 1];
        left[0] = height[0];
        for (int i = n - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], height[i]);
        for (int i = 1; i < n; i++)
            left[i] = Math.max(left[i - 1], height[i]);
        int water = 0;
        for (int i = 0; i < n; i++)
            water += (Math.min(left[i], right[i]) - height[i]);
        return water;
    }

    // Appraoch #2
    // full exaplaination in notes
    // every height will be bounded by a lower boundaries whether left or right , by
    // figuring which side to fill
    // by taking lower height side only ensures at it will be bounded by lower side
    // maximum
    // and accordingly switch pointers
    public int trap1(int[] height) {
        int water = 0, n = height.length;
        int l = 1, r = n - 2;
        int maxLeft = height[0], maxRight = height[n - 1];
        while (l <= r) {
            if (maxLeft <= maxRight) {
                maxLeft = Math.max(height[l], maxLeft);
                water += maxLeft - height[l];
                l++;
            } else {
                maxRight = Math.max(height[r], maxRight);
                water += maxRight - height[r];
                r--;
            }
        }
        return water;
    }

}
