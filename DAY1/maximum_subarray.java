package DAY1;

// tags : Implementation , Easy
class maximum_subarray {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            maxSoFar = Math.max(maxSoFar, sum);
            sum = Math.max(sum, 0);
        }
        return maxSoFar;
    }
}